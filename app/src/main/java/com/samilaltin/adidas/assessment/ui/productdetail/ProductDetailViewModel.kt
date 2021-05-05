package com.samilaltin.adidas.assessment.ui.productdetail

import androidx.databinding.ObservableBoolean
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.samilaltin.adidas.assessment.base.LiveCoroutinesViewModel
import com.samilaltin.adidas.assessment.network.data.ReviewRequest
import com.samilaltin.adidas.assessment.repository.ProductDetailRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import timber.log.Timber

class ProductDetailViewModel @ViewModelInject constructor(
    private val productDetailRepository: ProductDetailRepository
) : LiveCoroutinesViewModel() {

    private var getReviewsLiveData: MutableLiveData<Int> = MutableLiveData(0)

    //needs to call on product detail xml
    //and comment out the code block in the init function if want to show reviews on port 3002
    //val reviewListLiveData: LiveData<List<ReviewRequest>>

    private val _toastLiveData: MutableLiveData<String> = MutableLiveData()
    val toastLiveData: LiveData<String> get() = _toastLiveData
    val isLoading: ObservableBoolean = ObservableBoolean(false)
    var productId: String? = null

    init {
        Timber.d("init ProductDetailViewModel")
        /*reviewListLiveData = getReviewsLiveData.switchMap {
            isLoading.set(true)
            launchOnViewModelScope {
                productDetailRepository.getReviews(
                    productId,
                    onSuccess = { isLoading.set(false) },
                    onError = {}
                ).asLiveData()
            }
        }*/
    }

    fun postReview(review: ReviewRequest) {
        isLoading.set(true)
        viewModelScope.launch {
            productDetailRepository.postReview(review,
                onSuccess = { isLoading.set(false) },
                onError = {
                    _toastLiveData.postValue(it)
                    isLoading.set(false)
                }
            ).collect {}
        }
    }

    val clickListener = object :
        AddReviewBottomSheetFragment.SendReviewBottomSheetClickListener {
        override fun onSendReviewButtonClick(numStars: Int, review: String) {
            postReview(ReviewRequest("en-US", productId, numStars, review))
        }
    }
}