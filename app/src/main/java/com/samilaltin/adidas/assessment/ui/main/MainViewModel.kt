package com.samilaltin.adidas.assessment.ui.main

import androidx.annotation.MainThread
import androidx.databinding.ObservableBoolean
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.samilaltin.adidas.assessment.base.LiveCoroutinesViewModel
import com.samilaltin.adidas.assessment.network.data.ProductResponse
import com.samilaltin.adidas.assessment.repository.MainRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository
) : LiveCoroutinesViewModel() {

    private var getProductsLiveData: MutableLiveData<Int> = MutableLiveData(0)
    /* var productListLiveData: LiveData<List<ProductResponse>>
   val productListMutableLiveData: MutableLiveData<List<ProductResponse>> = MutableLiveData()*/

    val productResponseLiveData = MutableLiveData<List<ProductResponse>>()
    var productList: List<ProductResponse> = ArrayList()
    val isProductListVisible: ObservableBoolean = ObservableBoolean(true)

    private val _toastLiveData: MutableLiveData<String> = MutableLiveData()
    val toastLiveData: LiveData<String> get() = _toastLiveData

    val isLoading: ObservableBoolean = ObservableBoolean(true)

    init {
        Timber.d("init MainViewModel")

        /*productListLiveData = getProductsLiveData.switchMap {
            isLoading.set(true)
            launchOnViewModelScope {
                mainRepository.getProducts(
                    onSuccess = { isLoading.set(false) },
                    onError = {
                        _toastLiveData.postValue(it)
                        isLoading.set(false)
                    }
                ).asLiveData()
            }
        }*/

        viewModelScope.launch {
            mainRepository.getProducts(
                onSuccess = { isLoading.set(false) },
                onError = {
                    _toastLiveData.postValue(it)
                    isLoading.set(false)
                }
            ).collect {
                productResponseLiveData.postValue(it)
                productList = it
            }
        }
    }

    fun onSearchTextChanged(text: CharSequence?) {
        val resultList = this.productList.filter {
            it.name?.contains(text.toString()) == true || it.description?.contains(text.toString()) == true
        }
        isProductListVisible.set(resultList.isNotEmpty())
        productResponseLiveData.postValue(resultList)
    }

    // can be used for pagination
    // used for testing
    @MainThread
    fun getProducts(trigger: Int) {
        getProductsLiveData.value = trigger
    }
}