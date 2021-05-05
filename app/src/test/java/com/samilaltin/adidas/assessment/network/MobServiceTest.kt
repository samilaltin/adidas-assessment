package com.samilaltin.adidas.assessment.network

import com.samilaltin.adidas.assessment.MainCoroutinesRule
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MobServiceTest : ApiAbstract<AdidasService>() {

    private lateinit var service: AdidasService

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesRule = MainCoroutinesRule()

    @Before
    fun initService() {
        service = createService(AdidasService::class.java)
    }

    @Test
    fun getCategoriesFromNetworkTest() = runBlocking {
        enqueueResponse("response.json")
        val response = service.getProducts()
        val responseBody = requireNotNull((response as ApiResponse.Success).data)
        mockServer.takeRequest()

        assertThat(responseBody.isEmpty(), `is`(false))
        assertThat(responseBody[0].price, `is`(0))
        assertThat(responseBody[0].id, `is`("FI444"))
        assertThat(responseBody[0].name, `is`("product"))
        assertThat(responseBody[0].description, `is`("description"))
        assertThat(responseBody[0].reviews?.get(0)?.rating, `is`(3))
        assertThat(responseBody[0].reviews?.get(0)?.text, `is`("this product is the bestaaaa"))
    }
}