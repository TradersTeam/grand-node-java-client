import io.githhub.TradersTeam.grand_node_java_client.network.GrandNodeClient;
import io.githhub.TradersTeam.grand_node_java_client.network.apis.TestApi;
import retrofit2.converter.scalars.ScalarsConverterFactory;

class Test {
    public static void main(String... args) {
        @SuppressWarnings("SpellCheckingInspection")
        var token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJqdGkiOiJhNjcwNmE2Yy1jZDE0LTQwNWYtOTdkOC01YWJjYmZhYjljNmIiLCJFbWFpbCI6InlhbWluODAwMEB5YWhvby5jb20iLCJUb2tlbiI6IjE3Yzk5NWU5LTNhZTAtNGU5Mi05ZDIwLTk1MTYwNDUzMmYyOCIsImV4cCI6MTcyNjI4OTg4NX0._CD3jFSsMz1_-eiN2LcK1sAEFY69ZDhRP1DBRuoMRN4";

        var test = GrandNodeClient.builder()
                .apiKey(token)
                .converter(ScalarsConverterFactory.create())
                .build()
                .createDefaultInstance();

        var api = test.getRetrofit().create(TestApi.class).get();

//        api.async((stringResponse, throwable) -> {
//            if (stringResponse != null)
//                System.out.println(stringResponse.body());
//            else
//                System.out.println(throwable.getMessage());
//            return null;
//        });
//        api.enqueueAsyncBody((stringResponse, throwable) -> {
//            System.out.println(stringResponse.length());
//            if (stringResponse != null)
//                System.out.println(stringResponse);
//            else if (throwable != null)
//                System.out.println(throwable.getMessage());
//        });

        api.async(true, (response -> {
            System.out.println(response.body());
        }), (throwable -> {
            System.out.println(throwable.getMessage());
        }));

//        test.getRetrofit().create(TestApi.class).get().atomicAsync(((stringResponse, throwable) -> {
//            if (stringResponse != null)
//                System.out.println(stringResponse.body());
//            else
//                System.out.println(throwable.getMessage());
//        }));

//        test.getRetrofit().create(TestApi.class).get().enqueue(new Callback<>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                System.out.println(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                System.out.println(t.getMessage());
//            }
//        });
    }
}
