package io.githhub.TradersTeam.grand_node_java_client.network;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * An extension of {@link Call} that uses Java lambdas for the callbacks.
 * <p>
 * Callbacks are created using {@link Consumer}, {@link BiConsumer}, {@link BiFunction},
 * which are usable with Java 8+ lambdas and also have interoperability with Kotlin.
 * <h2>JVM</h2>
 * By convention, <b>atomic</b> callbacks are those that would shut down the client when the call is done.
 * This is useful for JVM only platforms, because OkHttp by default uses a non-daemon thread,
 * this will prevent the JVM from exiting until they time out. see here:
 * <p>
 * {@link okhttp3.Dispatcher#executorService()}
 * <h2>Android</h2>
 * However, for Android, default executor should be MainThreadExecutor,
 * which is tied to the UI thread.
 * <p>
 * {@link android.os.Handler}
 * <p>
 * {@link android.os.Looper}
 * <p>
 * So in conclusion, for Android it's better to use <b>enqueue</b> callbacks.
 * <p>
 *
 * @param <T> Successful response body type.
 */
@SuppressWarnings("unused")
public interface CallX<T> extends Call<T> {

    /**
     * A lambda wrapper around {@link Call#enqueue(Callback)}
     *
     * @param onResponse {@link Callback#onResponse(Call, Response)}
     * @param onFailure  {@link Callback#onFailure(Call, Throwable)}
     */
    void enqueue(@NotNull BiConsumer<Call<T>, Response<T>> onResponse, @NotNull BiConsumer<Call<T>, Throwable> onFailure);

    /**
     * <b>General purpose async call method.</b>
     * <p>
     * {@link  T} is a type parameter that is used to show the type of the response body.
     *
     * @param callback Represents the callback function which will be called when the request is finished or when an error occurs.
     *                 The callback function will be called with two parameters:
     *                 <ul>
     *                 <li>The first parameter is the generic retrofit response object. {@link Response<T>}</li>
     *                 <li>The second parameter is the throwable object. {@link Throwable}</li>
     *                 </ul>
     *                 The callback function will/shall return a boolean value which indicates whether the shutdown of the client is needed or not:
     *                 <ul>
     *                 <li>If the return value is true, the client will be shutdown.</li>
     *                 <li>If the return value is false, the client will not be shutdown.</li>
     *                 <li>If the return value is null, the client will not be shutdown.</li>
     *                 </ul>
     *                 The default value is false.
     *                 <p>
     *                 More info about why auto shutdown is needed:
     *                 <p>
     *                 By default, OkHttp uses non-daemon thread,
     *                 this will prevent the JVM from exiting until they time out.
     *                 however, if you are using OkHttp in a non-daemon thread, like Android, this is unnecessary.
     */
    void async(BiFunction<@Nullable Response<T>, @Nullable Throwable, @NotNull Boolean> callback);

    /**
     * Calls {@link #async(BiFunction)} but instead of determining whether to shut down the client or not
     * based on the return value of the callback function, it will be determined by the given boolean value.
     *
     * @param isShutdownNeeded The boolean value which determines whether to shut down the client or not.
     * @param callback         The callback function.
     */
    default void async(boolean isShutdownNeeded, BiConsumer<@Nullable Response<T>, @Nullable Throwable> callback) {
        async((response, throwable) -> {
            callback.accept(response, throwable);
            return isShutdownNeeded;
        });
    }

    /**
     * Calls {@link #async(BiFunction)} and automatically shuts down the client.
     *
     * @param callback The callback function.
     */
    default void atomicAsync(BiConsumer<@Nullable Response<T>, @Nullable Throwable> callback) {
        async((response, throwable) -> {
            callback.accept(response, throwable);
            return true;
        });
    }

    /**
     * Calls {@link #async(BiFunction)} and doesn't care whether to shut down the client or not.
     *
     * @param callback The callback function.
     */
    default void enqueueAsync(BiConsumer<@Nullable Response<T>, @Nullable Throwable> callback) {
        async((response, throwable) -> {
            callback.accept(response, throwable);
            return false;
        });
    }

    /**
     * Calls {@link #async(boolean, BiConsumer)} but instead of determining whether to shut down the client or not
     * based on the return value of the callback function, it will be determined by the given boolean value.
     * <p>
     * However, this method only returns the response body.
     * <p>
     * This method is useful when you want to get the response body without caring about the response status code or headers.
     *
     * @param isShutdownNeeded The boolean value which determines whether to shut down the client or not.
     * @param callback         The callback function.
     */
    default void asyncBody(boolean isShutdownNeeded, BiConsumer<@Nullable T, @Nullable Throwable> callback) {
        async(isShutdownNeeded, (response, throwable) -> {
            if (response == null) callback.accept(null, throwable);
            else callback.accept(response.body(), throwable);
        });
    }

    /**
     * Calls {@link #asyncBody(boolean, BiConsumer)} with false parameter and returns the response body.
     * <p>
     * This method is useful when you want to get the response body without caring about the response status code.
     * <p>
     * This method don't care whether to shut down the client or not.
     *
     * @param callback The callback function.
     */
    default void enqueueAsyncBody(BiConsumer<@Nullable T, @Nullable Throwable> callback) {
        asyncBody(false, callback);
    }

    /**
     * Calls {@link #asyncBody(boolean, BiConsumer)} with true parameter and returns the response body.
     * <p>
     * This method is useful when you want to get the response body without caring about the response status code.
     * <p>
     * This method will shut down the client after the callback function is called.
     *
     * @param callback The callback function.
     */
    default void atomicAsyncBody(BiConsumer<@Nullable T, @Nullable Throwable> callback) {
        asyncBody(true, callback);
    }

    /**
     * <b>General purpose async call method with two callbacks</b>
     *
     * @param isShutdownNeeded The boolean value which determines whether to shut down the client or not.
     * @param onSuccess        The callback function which is called when an HTTP response is received and is not canceled.
     * @param onFailure        The callback function which is called when a network exception occurred talking to the server or
     *                         when an unexpected exception occurred creating the request or processing the response.
     */
    void async(boolean isShutdownNeeded, Consumer<@Nullable Response<T>> onSuccess, Consumer<Throwable> onFailure);

    /**
     * Calls {@link #async(boolean, Consumer, Consumer)} and automatically shuts down the client.
     *
     * @param onSuccess The callback function which is called when an HTTP response is received and is not canceled.
     * @param onFailure The callback function which is called when a network exception occurred talking to the server or
     *                  when an unexpected exception occurred creating the request or processing the response.
     */
    default void atomicAsync(Consumer<@Nullable Response<T>> onSuccess, Consumer<Throwable> onFailure) {
        async(true, onSuccess, onFailure);
    }

    /**
     * Calls {@link #async(boolean, Consumer, Consumer)} and doesn't care whether to shut down the client or not.
     *
     * @param onSuccess The callback function which is called when an HTTP response is received and is not canceled.
     * @param onFailure The callback function which is called when a network exception occurred talking to the server or
     */
    default void enqueueAsync(Consumer<@Nullable Response<T>> onSuccess, Consumer<Throwable> onFailure) {
        async(false, onSuccess, onFailure);
    }

    /**
     * Calls {@link #async(boolean, Consumer, Consumer)} and returns the response body.
     * * <p>
     * * This method is useful when you want to get the response body without caring about the response status code or headers.
     *
     * @param isShutdownNeeded The boolean value which determines whether to shut down the client or not.
     * @param onSuccess        The callback function which is called when an HTTP response is received and is not canceled.
     * @param onFailure        The callback function which is called when a network exception occurred talking to the server or
     *                         when an unexpected exception occurred creating the request or processing the response.
     */
    default void asyncBody(
            boolean isShutdownNeeded,
            @NotNull Consumer<@Nullable T> onSuccess,
            @NotNull Consumer<@Nullable Throwable> onFailure
    ) {
        async(isShutdownNeeded, (response) -> {
            if (response != null) onSuccess.accept(response.body());
            else onSuccess.accept(null);
        }, onFailure);
    }

    /**
     * Calls {@link #asyncBody(boolean, Consumer, Consumer)} with false parameter so it doesn't care about whether to shut down client or not
     *
     * @param onSuccess The callback function which is called when an HTTP response is received and is not canceled.
     * @param onFailure The callback function which is called when a network exception occurred talking to the server or
     */
    default void enqueueAsyncBody(
            @NotNull Consumer<@Nullable T> onSuccess,
            @NotNull Consumer<@Nullable Throwable> onFailure
    ) {
        asyncBody(false, onSuccess, onFailure);
    }

    /**
     * Calls {@link #enqueueAsync(Consumer, Consumer)} and definitely returns a Non-Null response body,
     * Actually if response body is null then default value provided by defaultValueSupplier is returned.
     *
     * @param onSuccess            The callback function which is called when an HTTP response is received and is not canceled.
     * @param onFailure            The callback function which is called when a network exception occurred talking to the server or
     * @param defaultValueSupplier a supplier for supplying a default value in case response body is null
     */
    default void enqueueAsyncBody(
            @NotNull Consumer<@NotNull T> onSuccess,
            @NotNull Consumer<@Nullable Throwable> onFailure,
            @NotNull Supplier<@NotNull T> defaultValueSupplier
    ) {
        enqueueAsyncBody((response) -> {
            if (response == null) onSuccess.accept(defaultValueSupplier.get());
            else onSuccess.accept(response);
        }, onFailure);
    }
}
