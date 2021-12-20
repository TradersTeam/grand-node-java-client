import io.githhub.TradersTeam.grand_node_java_client.network.GrandNodeClient;
import io.githhub.TradersTeam.grand_node_java_client.network.apis.TestApi;
import retrofit2.converter.scalars.ScalarsConverterFactory;

class Test {
    public static void main(String... args) {
        var test = GrandNodeClient.builder()
                .apiKey(API.token)
                .baseUrl(API.url)
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
