///*
//package io.githhub.TradersTeam.grand_node_java_client.network;
//
//import okhttp3.Interceptor;
//import okhttp3.OkHttpClient;
//import okhttp3.Response;
//import org.jetbrains.annotations.NotNull;
//import retrofit2.Converter;
//import retrofit2.Retrofit;
//
//import java.io.IOException;
//
//public static class CustomBuilder extends GrandNodeClient.GrandNodeClientBuilder {
//
//    private GrandNodeClient Client;
//
//    private @NotNull Response ApiInterceptor(Interceptor.Chain chain) throws IOException {
//        var requestBuilder = chain.request().newBuilder();
//        requestBuilder = requestBuilder.addHeader(Constants.AUTHORIZATION, Constants.BEARER + " " + Client.apiKey);
//        return chain.proceed(requestBuilder.build());
//    }
//
//    @NotNull
//    private CallXAdapterFactory getCallXAdapterFactory() {
//        CallXAdapterFactory callXAdapterFactory;
//        if (Client.callbackExecutor != null)
//            callXAdapterFactory = new CallXAdapterFactory(Client.okHttpClient, Client.callbackExecutor);
//        else callXAdapterFactory = new CallXAdapterFactory(Client.okHttpClient);
//        return callXAdapterFactory;
//    }
//
//    @Override
//    public GrandNodeClient build() {
//        Client = super.build();
//        if (Client.okHttpClient == null)
//            Client.okHttpClient = new OkHttpClient.Builder().build();
//
//        Client.okHttpClient = Client.okHttpClient.newBuilder().addInterceptor(this::ApiInterceptor).build();
//
//        if (Client.retrofit == null)
//            Client.retrofit = new Retrofit.Builder().baseUrl(Client.baseUrl).build();
//
//        Client.retrofit = Client.retrofit.newBuilder().client(Client.okHttpClient).build();
//
//        var retrofitBuilder = Client.retrofit.newBuilder();
//
//        CallXAdapterFactory callXAdapterFactory = getCallXAdapterFactory();
//        retrofitBuilder.addCallAdapterFactory(callXAdapterFactory);
//
//        for (Converter.Factory converter : Client.converters)
//            retrofitBuilder.addConverterFactory(converter);
//
//        Client.retrofit = retrofitBuilder.build();
//
//        return Client;
//    }
//}*/
