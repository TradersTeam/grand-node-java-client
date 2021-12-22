package io.githhub.TradersTeam.grand_node_java_client.network.apis;

import io.githhub.TradersTeam.grand_node_java_client.models.Brand;
import io.githhub.TradersTeam.grand_node_java_client.network.CallX;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.*;

import java.util.List;

public interface BrandAPIs {

    String BRAND = "Brand";

    /**
     * Search brand entities by query parameters
     *
     * @param top     Show only the first n items.
     * @param skip    Skip the first n items.
     * @param count   Include count of items
     * @param orderBy Order items by property values
     * @param filter  Filter items by property values
     * @return List of brand entities
     */
    @GET(R.ODATA + BRAND)
    CallX<List<Brand>> search(
            @Query(R.TOP) Integer top,
            @Query(R.SKIP) Integer skip,
            @Query(R.COUNT) Boolean count,
            @Query(R.ORDER_BY) String orderBy,
            @Query(R.FILTER) String filter
    );

    /**
     * Get all brand entities
     *
     * @return List of all brand entities
     */
    default CallX<List<Brand>> getAll() {
        return search(null, null, null, null, null);
    }

    /**
     * Create a new brand entity
     *
     * @param brand brand entity
     * @return created brand entity
     */
    @POST(R.ODATA + BRAND)
    CallX<Brand> create(@NotNull @Body Brand brand);

    /**
     * Get a brand by id
     *
     * @param key brand id
     * @return List of brands that only contains one brand entity or null if not found
     */
    @GET(R.ODATA + BRAND + "/{key}")
    CallX<List<Brand>> get(@NotNull @Path("key") String key);
}
