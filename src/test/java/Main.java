import io.githhub.TradersTeam.grand_node_java_client.network.GrandNodeClient;
import io.githhub.TradersTeam.grand_node_java_client.network.apis.TestApi;
import retrofit2.converter.scalars.ScalarsConverterFactory;

class Main {
    public static void main(String... args) {
        System.out.println("Hello, World!");

        @SuppressWarnings("SpellCheckingInspection")
        var token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJqdGkiOiJhNjcwNmE2Yy1jZDE0LTQwNWYtOTdkOC01YWJjYmZhYjljNmIiLCJFbWFpbCI6InlhbWluODAwMEB5YWhvby5jb20iLCJUb2tlbiI6IjE3Yzk5NWU5LTNhZTAtNGU5Mi05ZDIwLTk1MTYwNDUzMmYyOCIsImV4cCI6MTcyNjI4OTg4NX0._CD3jFSsMz1_-eiN2LcK1sAEFY69ZDhRP1DBRuoMRN4";

        var client = GrandNodeClient.builder()
                .apiKey(token)
                .converter(ScalarsConverterFactory.create())
                .build()
                .createDefaultInstance();

        client.getRetrofit().create(TestApi.class).get().atomicAsync(stringResponse -> {
            if (stringResponse != null) {
                System.out.println(stringResponse);
            } else System.out.println("response is null");
        }, throwable -> {
            System.out.println(throwable.getMessage());
        });
    }
}
