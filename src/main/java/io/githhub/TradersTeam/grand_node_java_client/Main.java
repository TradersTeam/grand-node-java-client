package io.githhub.TradersTeam.grand_node_java_client;

import io.githhub.TradersTeam.grand_node_java_client.network.GrandNodeClient;
import io.githhub.TradersTeam.grand_node_java_client.network.apis.TestApi;
import io.githhub.TradersTeam.grand_node_java_client.network.util.ApiKeys;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Main {
    public static void main(String... args) {
        System.out.println("Hello, World!");

        var client = GrandNodeClient.builder()
                .apiKey(ApiKeys.token)
                .converter(ScalarsConverterFactory.create())
                .build()
                .createDefaultInstance();

        client.getRetrofit().create(TestApi.class).get().atomicAsync(stringResponse -> {
            if (stringResponse != null) {
                System.out.println(stringResponse);
            } else System.out.println("response is null");
        }, throwable -> {
            System.out.println(throwable.getMessage());
        });
    }
}
