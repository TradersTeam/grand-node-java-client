package io.githhub.TradersTeam.grand_node_java_client.network;

import io.githhub.TradersTeam.grand_node_java_client.network.util.Constants;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

@Builder
@Getter
public class GrandNodeClient {

    private Retrofit retrofit;
    private OkHttpClient okHttpClient;
    private String baseUrl;
    @Singular
    private List<Converter.Factory> converters;
    private boolean isClientAutoShutDowned;
    private String apiKey;

    public GrandNodeClient createDefaultInstance() {
        if (baseUrl == null)
            baseUrl = Constants.baseUrl;

        if (okHttpClient == null)
            okHttpClient = new OkHttpClient.Builder().build();

        okHttpClient = okHttpClient.newBuilder().addInterceptor(this::ApiInterceptor).build();

        if (retrofit == null)
            retrofit = new Retrofit.Builder().baseUrl(baseUrl).build();

        retrofit = retrofit.newBuilder().client(okHttpClient).build();

        var retrofitBuilder = retrofit.newBuilder();
        for (Converter.Factory converter : converters)
            retrofitBuilder.addConverterFactory(converter);
        retrofit = retrofitBuilder.build();

        return this;
    }

    private @NotNull Response ApiInterceptor(Interceptor.Chain chain) throws IOException {
        var requestBuilder = chain.request().newBuilder();
        requestBuilder = requestBuilder.addHeader(Constants.AUTHORIZATION, Constants.BEARER + " " + apiKey);
        return chain.proceed(requestBuilder.build());
    }
}
