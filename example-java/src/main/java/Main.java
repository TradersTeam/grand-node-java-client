import io.githhub.TradersTeam.grand_node_java_client.models.Brand;
import io.githhub.TradersTeam.grand_node_java_client.network.GrandNodeClient;
import io.githhub.TradersTeam.grand_node_java_client.network.apis.BrandAPIs;
import io.githhub.TradersTeam.grand_node_java_client.network.apis.CategoryAPIs;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String... args) throws IOException {

        var client = GrandNodeClient.builder()
                .apiKey(API.token)
                .baseUrl(API.url)
                .converter(GsonConverterFactory.create())
                .build()
                .createDefaultInstance();

        //updateApiTest(client);

//        client.create(BrandAPIs.class).getAll().atomicAsync(listResponse -> {
//                    if (listResponse != null)
//                        Output.success(listResponse.body().get(0).getName());
//                    else Output.error("response is null");
//                }, throwable ->
//                        Output.error(throwable.getMessage())
//        );

//        client.create(CategoryAPIs.class).search(null, null, null, null, null).atomicAsync(listResponse -> {
//                    if (listResponse != null)
//                        Output.success(listResponse.body().get(0).getName());
//                    else Output.error("response is null");
//                }, throwable ->
//                        Output.error(throwable.getMessage())
//        );
    }

    private static void updateApiTest(GrandNodeClient client) throws IOException {
        var brandApi = client.create(BrandAPIs.class);
        var firstBrand = brandApi.getAll().execute().body().get(0);
        //firstBrand = firstBrand.toBuilder().Description("new description").build();
        Output.success(firstBrand.getName());
        var scanner = new Scanner(System.in);
        var newDescription = scanner.nextLine();
        firstBrand.setDescription(newDescription);
        var updateResponse = brandApi.update(firstBrand).execute();
        Output.success(String.valueOf((updateResponse.code())));
        Output.success((updateResponse.body().getDescription()));
    }
}
