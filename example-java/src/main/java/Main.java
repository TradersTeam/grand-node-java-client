import io.githhub.TradersTeam.grand_node_java_client.network.GrandNodeClient;
import io.githhub.TradersTeam.grand_node_java_client.network.apis.BrandAPIs;
import retrofit2.converter.gson.GsonConverterFactory;

class Main {
    public static void main(String... args) {
        System.out.println("Hello, World!");

        var client = GrandNodeClient.builder()
                .apiKey(API.token)
                .baseUrl(API.url)
                .converter(GsonConverterFactory.create())
                .build()
                .createDefaultInstance();

        client.getRetrofit().create(BrandAPIs.class).getAll().atomicAsync(listResponse -> {
            if (listResponse != null) {
                System.out.println(listResponse);
            } else System.out.println("response is null");
        }, throwable -> {
            System.out.println(throwable.getMessage());
        });
    }
}
