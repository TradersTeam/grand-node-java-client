import io.githhub.TradersTeam.grand_node_java_client.models.Brand
import io.githhub.TradersTeam.grand_node_java_client.network.GrandNodeClient
import io.githhub.TradersTeam.grand_node_java_client.network.apis.BrandAPIs
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.*

fun main() {
    val client = GrandNodeClient.builder()
        .apiKey(API.token)
        .baseUrl(API.url)
        .converter(GsonConverterFactory.create())
        .build()
        .createDefaultInstance()

    val api = client.retrofit.create(BrandAPIs::class.java)
    val response = api.all.execute().body()!!.last()
    println("Brand: ${response.seName} - ${response.id}")
    val scanner = Scanner(System.`in`)
    val input = scanner.nextLine()
    if (input == "y") {
        api.delete("response.id").enqueue({ _, deleteResponse ->
            println(deleteResponse.code())
        }, { _, t ->
            println(t.message)
        })
    }

//createBrand(client)

//    api.async { response, throwable ->
//        println(response?.body()?.first()?.name)
//        return@async true
//    }

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

private fun createBrand(client: GrandNodeClient) {
    val brand = Brand.builder()
        .Name("Brand")
        .SeName("Brand")
        .Description("Brand")
        .BottomDescription("Brand")
        .BrandLayoutId(null)
        .MetaKeywords("Brand")
        .MetaDescription("Brand")
        .MetaTitle("Brand")
        .PictureId(null)
        .PageSize(0)
        .AllowCustomersToSelectPageSize(false)
        .PageSizeOptions("Brand")
        .ShowOnHomePage(false)
        .IncludeInTopMenu(false)
        .Icon(null)
        .Published(true)
        .ExternalId("")
        .build()

    client.retrofit.create<BrandAPIs>().create(brand).atomicAsync { response, throwable ->
        if (response != null && throwable == null) {
            println(response.body()?.id)
        } else {
            println(throwable)
        }
    }
}