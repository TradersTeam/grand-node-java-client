package io.githhub.TradersTeam.grand_node_java_client.network.apis;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TestApi {

    @GET("product")
    Call<String> get();
}
