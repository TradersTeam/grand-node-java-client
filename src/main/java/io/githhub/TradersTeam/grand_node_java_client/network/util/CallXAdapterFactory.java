package io.githhub.TradersTeam.grand_node_java_client.network.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import retrofit2.*;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class CallXAdapterFactory extends CallAdapter.Factory {

    private static OkHttpClient okHttpClient = null;

    public CallXAdapterFactory(OkHttpClient okHttpClient) {
        CallXAdapterFactory.okHttpClient = okHttpClient;
    }

    @Override
    public CallAdapter<?, ?> get(@NotNull Type type, Annotation @NotNull [] annotations, @NotNull Retrofit retrofit) {
        //this line will allow retrofit to use default call adapter for types other than CallX
        if (getRawType(type) != CallX.class) return null;

        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("Call must have generic type (e.g., Call<ResponseBody>)");
        }

        final Type responseType = getParameterUpperBound(0, (ParameterizedType) type);
        return new CallXAdapter<>(responseType);
    }

    private static final class CallXAdapter<R> implements CallAdapter<R, CallX<R>> {
        private final Type responseType;

        CallXAdapter(Type responseType) {
            this.responseType = responseType;
        }

        @Override
        public @NotNull Type responseType() {
            return responseType;
        }

        @Override
        public @NotNull CallX<R> adapt(@NotNull Call<R> call) {
            return new MyCallXAdapter<>(call);
        }
    }

    private static class MyCallXAdapter<T> implements CallX<T> {
        private final Call<T> call;

        MyCallXAdapter(Call<T> call) {
            this.call = call;
        }

        @Override
        public @NotNull Response<T> execute() throws IOException {
            return call.execute();
        }

        @Override
        public void enqueue(@NotNull Callback<T> callback) {
            call.enqueue(callback);
        }

        @Override
        public boolean isExecuted() {
            return call.isExecuted();
        }

        @Override
        public void cancel() {
            call.cancel();
        }

        @Override
        public boolean isCanceled() {
            return call.isCanceled();
        }

        @Override
        public @NotNull Call<T> clone() {
            return new MyCallXAdapter<>(call.clone());
        }

        @Override
        public @NotNull Request request() {
            return call.request();
        }

        @Override
        public @NotNull Timeout timeout() {
            return call.timeout();
        }

        @Override
        public void async(BiFunction<Response<T>, Throwable, Boolean> callback) {
            call.enqueue(new Callback<>() {
                @Override
                public void onResponse(@NotNull Call<T> call, @NotNull Response<T> response) {
                    var isShutdownNeeded = false;

                    if (call.isCanceled())
                        isShutdownNeeded = callback.apply(null, new IOException("Canceled"));
                    else
                        isShutdownNeeded = callback.apply(response, null);

                    if (isShutdownNeeded)
                        shutdown();
                }

                @Override
                public void onFailure(@NotNull Call<T> call, @NotNull Throwable t) {
                    var isShutdownNeeded = false;

                    isShutdownNeeded = callback.apply(null, t);
                    if (isShutdownNeeded)
                        shutdown();
                }
            });
        }

        @Override
        public void async(boolean isShutdownNeeded, Consumer<Response<T>> onSuccess, Consumer<Throwable> onFailure) {
            call.enqueue(new Callback<>() {
                @Override
                public void onResponse(@NotNull Call<T> call, @NotNull Response<T> response) {
                    if (call.isCanceled())
                        onFailure.accept(new IOException("Canceled"));
                    else
                        onSuccess.accept(response);

                    if (isShutdownNeeded)
                        shutdown();
                }

                @Override
                public void onFailure(@NotNull Call<T> call, @NotNull Throwable t) {
                    onFailure.accept(t);

                    if (isShutdownNeeded)
                        shutdown();
                }
            });
        }

        /**
         * By default, OkHttp uses non-daemon thread,
         * this will prevent the JVM from exiting until they time out.
         * so this method is used for shutting down threads manually.
         */
        private void shutdown() {
            if (okHttpClient != null) {
                okHttpClient.dispatcher().executorService().shutdown();
                okHttpClient.connectionPool().evictAll();
            }
        }
    }
}
