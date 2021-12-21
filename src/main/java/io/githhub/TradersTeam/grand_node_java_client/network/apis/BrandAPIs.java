package io.githhub.TradersTeam.grand_node_java_client.network.apis;

import io.githhub.TradersTeam.grand_node_java_client.models.Brand;
import io.githhub.TradersTeam.grand_node_java_client.network.CallX;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface BrandAPIs {

    String BRAND = "Brand";

    @GET(R.ODATA + BRAND)
    CallX<List<Brand>> getAll();

    @POST(R.ODATA + BRAND)
    CallX<Brand> create(@Body Brand brand);
}
