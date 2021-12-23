import io.githhub.TradersTeam.grand_node_java_client.network.GrandNodeClient;
import io.githhub.TradersTeam.grand_node_java_client.network.apis.CategoryAPIs;
import retrofit2.converter.gson.GsonConverterFactory;

class Main {
    public static void main(String... args) {

        var client = GrandNodeClient.builder()
                .apiKey(API.token)
                .baseUrl(API.url)
                .converter(GsonConverterFactory.create())
                .build()
                .createDefaultInstance();

//        client.create(BrandAPIs.class).getAll().atomicAsync(listResponse -> {
//                    if (listResponse != null)
//                        Output.success(listResponse.body().get(0).getName());
//                    else Output.error("response is null");
//                }, throwable ->
//                        Output.error(throwable.getMessage())
//        );

        client.create(CategoryAPIs.class).search(null, null, null, null, null).atomicAsync(listResponse -> {
                    if (listResponse != null)
                        Output.success(listResponse.body().get(0).getName());
                    else Output.error("response is null");
                }, throwable ->
                        Output.error(throwable.getMessage())
        );
    }
}
