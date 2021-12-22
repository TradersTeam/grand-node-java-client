package io.githhub.TradersTeam.grand_node_java_client.network.apis;

import io.githhub.TradersTeam.grand_node_java_client.models.Brand;
import io.githhub.TradersTeam.grand_node_java_client.network.CallX;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface BrandAPIs {

    String BRAND = "Brand";

    /**
     * Get all brands
     *
     * @return List of brands
     */
    @GET(R.ODATA + BRAND)
    CallX<List<Brand>> getAll();

    /**
     * Create a new brand entity
     *
     * @param brand brand entity
     * @return created brand entity
     */
    @POST(R.ODATA + BRAND)
    CallX<Brand> create(@Body Brand brand);

    /**
     * Get a brand by id
     *
     * @param key brand id
     * @return List of brands that only contains one brand entity or null if not found
     */
    @GET(R.ODATA + BRAND + "/{key}")
    CallX<List<Brand>> get(@Path("key") String key);
}
