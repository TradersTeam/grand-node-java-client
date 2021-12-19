@file:Suppress("PackageName", "ControlFlowWithEmptyBody", "UNUSED_ANONYMOUS_PARAMETER")

import io.githhub.TradersTeam.grand_node_java_client.network.GrandNodeClient
import io.githhub.TradersTeam.grand_node_java_client.network.apis.TestApi
import retrofit2.create

private class TestK {
    init {
        val test = GrandNodeClient.builder().build().createDefaultInstance()
        val api = test.retrofit.create<TestApi>().get()

        api.async { response, throwable ->

            return@async true
        }

        api.enqueueAsync { response, throwable ->
            if (throwable != null) {
                //println(throwable.message)
            } else {
                //println(response.body())
            }
        }

        api.atomicAsync { response, throwable ->

        }

        api.async(true) { response, throwable ->

        }

        api.enqueueAsyncBody { s, throwable -> }


        api.atomicAsyncBody { s, throwable ->

        }

        api.async(true, {

        }, {

        })

        api.atomicAsync({
            var test = it?.body()
        }, {
            val message = it.message
        })
    }
}