package com.samilaltin.adidas.assessment.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.nhaarman.mockitokotlin2.atLeastOnce
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.samilaltin.adidas.assessment.MainCoroutinesRule
import com.samilaltin.adidas.assessment.MockUtil.mockProducts
import com.samilaltin.adidas.assessment.network.AdidasService
import com.samilaltin.adidas.assessment.network.data.ProductResponse
import com.samilaltin.adidas.assessment.repository.MainRepository
import com.samilaltin.adidas.assessment.ui.main.MainViewModel
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

@ExperimentalCoroutinesApi
class MainViewModelTest {

    private lateinit var viewModel: MainViewModel
    private lateinit var mainRepository: MainRepository
    private val service: AdidasService = mock()

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesRule = MainCoroutinesRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        mainRepository = MainRepository(service)
        viewModel = MainViewModel(mainRepository)
    }

    @Test
    fun getProductsTest() = runBlocking {
        val mockData = mockProducts()
        whenever(service.getProducts()).thenReturn(ApiResponse.of { Response.success(mockData) })

        val observer: Observer<List<ProductResponse>> = mock()
        val fetchedData: LiveData<List<ProductResponse>> =
            mainRepository.getProducts(onSuccess = {}, onError = {}).asLiveData()
        fetchedData.observeForever(observer)
        viewModel.getProducts(1)

        verify(service, atLeastOnce()).getProducts()
        verify(observer).onChanged(mockData)
        fetchedData.removeObserver(observer)
    }
}