package io.githhub.TradersTeam.grand_node_java_client.network.util;

import okhttp3.OkHttpClient;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.Response;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public interface CallX<T> extends Call<T> {

    void async(@Nullable OkHttpClient okHttpClient, BiFunction<Response<T>, Throwable, Boolean> callback);

    default void async(OkHttpClient okHttpClient, BiConsumer<Response<T>, Throwable> callback) {
        async(okHttpClient, (response, throwable) -> {
            callback.accept(response, throwable);
            return false;
        });
    }

    default void asyncBody(OkHttpClient okHttpClient, BiConsumer<T, Throwable> callback) {
        async(okHttpClient, (response, throwable) -> {
            callback.accept(response.body(), throwable);
            return false;
        });
    }

    default void async(BiConsumer<Response<T>, Throwable> callback) {
        async(null, callback);
    }

    default void asyncBody(BiConsumer<T, Throwable> callback) {
        asyncBody(null, callback);
    }
}
