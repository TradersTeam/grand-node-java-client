import io.githhub.TradersTeam.grand_node_java_client.network.GrandNodeClient
import io.githhub.TradersTeam.grand_node_java_client.network.apis.BrandAPIs
import retrofit2.converter.gson.GsonConverterFactory

fun main() {
    val client = GrandNodeClient.builder()
        .apiKey(API.token)
        .baseUrl(API.url)
        .converter(GsonConverterFactory.create())
        .build()
        .createDefaultInstance()

    val api = client.retrofit.create(BrandAPIs::class.java).all

    api.async { response, throwable ->
        println(response?.body()?.first()?.name)
        return@async true
    }

//    api.enqueueAsync { response, throwable ->
//        if (throwable != null) {
//            //println(throwable.message)
//        } else {
//            //println(response.body())
//        }
//    }
//
//    api.atomicAsync { response, throwable ->
//
//    }
//
//    api.async(true) { response, throwable ->
//
//    }
//
//    api.enqueueAsyncBody { s, throwable -> }
//
//
//    api.atomicAsyncBody { s, throwable ->
//
//    }
//
//    api.async(true, {
//
//    }, {
//
//    })
//
//    api.atomicAsync({
//        var test = it?.body()
//    }, {
//        val message = it.message
//    })
}