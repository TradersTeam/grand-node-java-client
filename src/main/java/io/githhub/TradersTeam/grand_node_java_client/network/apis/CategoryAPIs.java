package io.githhub.TradersTeam.grand_node_java_client.network.apis;

import io.githhub.TradersTeam.grand_node_java_client.models.Brand;
import io.githhub.TradersTeam.grand_node_java_client.models.Category;
import io.githhub.TradersTeam.grand_node_java_client.network.CallX;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface CategoryAPIs {

    String CATEGORY = "Category";

    /**
     * Search category entities by query parameters
     *
     * @param top     Show only the first n items.
     * @param skip    Skip the first n items.
     * @param count   Include count of items
     * @param orderBy Order items by property values
     * @param filter  Filter items by property values
     * @return List of category entities
     */
    @GET(R.ODATA + CATEGORY)
    CallX<List<Category>> search(
            @Query(R.TOP) Integer top,
            @Query(R.SKIP) Integer skip,
            @Query(R.COUNT) Boolean count,
            @Query(R.ORDER_BY) String orderBy,
            @Query(R.FILTER) String filter
    );

    /**
     * Get all category entities
     *
     * @return List of all category entities
     */
    default CallX<List<Category>> getAll() {
        return search(null, null, null, null, null);
    }

}
