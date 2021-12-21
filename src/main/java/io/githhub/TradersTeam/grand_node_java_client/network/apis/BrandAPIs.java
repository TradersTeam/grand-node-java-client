package io.githhub.TradersTeam.grand_node_java_client.network.apis;

import io.githhub.TradersTeam.grand_node_java_client.models.Brand;
import io.githhub.TradersTeam.grand_node_java_client.network.CallX;
import retrofit2.http.GET;

import java.util.List;

public interface BrandAPIs {

    @GET(R.ODATA + "Brand")
    CallX<List<Brand>> getAll();
}
