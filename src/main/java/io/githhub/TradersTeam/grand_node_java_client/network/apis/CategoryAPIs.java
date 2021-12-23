package io.githhub.TradersTeam.grand_node_java_client.network.apis;

import io.githhub.TradersTeam.grand_node_java_client.models.Category;
import io.githhub.TradersTeam.grand_node_java_client.network.CallX;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.*;

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

    /**
     * Create a new category entity
     *
     * @param category category entity
     * @return created category entity
     */
    @POST(R.ODATA + CATEGORY)
    CallX<Category> create(@NotNull @Body Category category);

    /**
     * Get a category by id
     *
     * @param key category id
     * @return List of categories that only contains one category entity or null if not found
     */
    @GET(R.ODATA + CATEGORY + "/{key}")
    CallX<List<Category>> get(@NotNull @Path("key") String key);

    /**
     * Delete a category by id
     *
     * @param key category id
     * @return If the category was found and deleted HTTP response code is 200 and if the category was not found HTTP response code is 404
     */
    @DELETE(R.ODATA + CATEGORY)
    CallX<Void> delete(@NotNull @Query("key") String key);
}
