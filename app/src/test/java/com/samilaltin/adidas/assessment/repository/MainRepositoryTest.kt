package com.samilaltin.adidas.assessment.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.nhaarman.mockitokotlin2.atLeastOnce
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.samilaltin.adidas.assessment.MainCoroutinesRule
import com.samilaltin.adidas.assessment.MockUtil.mockProducts
import com.samilaltin.adidas.assessment.network.AdidasService
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

@ExperimentalCoroutinesApi
class MainRepositoryTest {

    private lateinit var repository: MainRepository
    private val service: AdidasService = mock()

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesRule = MainCoroutinesRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        repository = MainRepository(service)
    }

    @Test
    fun getProductsFromNetworkTest(): Unit = runBlocking {
        val mockData = mockProducts()
        whenever(service.getProducts()).thenReturn(ApiResponse.of { Response.success(mockData) })
        repository.getProducts(onError = {}, onSuccess = {})
            .test {
                Assert.assertEquals(expectItem()[0].price, 0)
                Assert.assertEquals(expectItem()[0].id, "FI444")
                Assert.assertEquals(expectItem()[0].name, "product")
                Assert.assertEquals(expectItem()[0].description, "description")
                Assert.assertEquals(expectItem()[0].reviews?.get(0)?.productId, expectItem()[0].id)
            }
        verify(service, atLeastOnce()).getProducts()
    }
}