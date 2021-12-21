import io.githhub.TradersTeam.grand_node_java_client.network.GrandNodeClient;
import io.githhub.TradersTeam.grand_node_java_client.network.apis.BrandAPIs;
import retrofit2.converter.gson.GsonConverterFactory;

class Main {
    public static void main(String... args) {
        Output.message("Hello, World!");

        var client = GrandNodeClient.builder()
                .apiKey(API.token)
                .baseUrl(API.url)
                .converter(GsonConverterFactory.create())
                .build()
                .createDefaultInstance();

        client.create(BrandAPIs.class).getAll().atomicAsync(listResponse -> {
                    if (listResponse != null)
                        Output.success(listResponse.body().get(0).getName());
                    else Output.error("response is null");
                }, throwable ->
                        Output.error(throwable.getMessage())
        );
    }
}
