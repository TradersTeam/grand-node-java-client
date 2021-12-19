package io.githhub.TradersTeam.grand_node_java_client.network.apis;

import io.githhub.TradersTeam.grand_node_java_client.network.CallX;
import retrofit2.http.GET;

public interface TestApi {

    @GET("product")
    CallX<String> get();
}
