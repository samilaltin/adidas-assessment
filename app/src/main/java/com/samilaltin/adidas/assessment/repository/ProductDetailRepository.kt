package com.samilaltin.adidas.assessment.repository

import androidx.annotation.WorkerThread
import com.samilaltin.adidas.assessment.network.AdidasReviewService
import com.samilaltin.adidas.assessment.network.data.ReviewRequest
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ProductDetailRepository @Inject constructor(private val service: AdidasReviewService) {
    @WorkerThread
    suspend fun postReview(
        review: ReviewRequest,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) = flow {
        val response = service.postReview(review.productId, review)

        response.suspendOnSuccess {
            data?.let {
                emit(it)
                onSuccess()
            }
        }
            // handle api request error
            /** we can create a error response mapper here.*/
            /** it maps the ApiResponse Error to the our ErrorResponse class using the mapper. */
            .onError {
                onError(message())
            }
            // handle api request exception
            .onException {
                //for example we can catch connection exception here and do things. right now we are showing toast message.
                onError(message())
            }
    }.flowOn(Dispatchers.IO)

    @WorkerThread
    suspend fun getReviews(
        productId: String?,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) = flow {
        val response = service.getReviews(productId)

        response.suspendOnSuccess {
            data?.let {
                emit(it)
                onSuccess()
            }
        }
            // handle api request error
            /** we can create a error response mapper here.*/
            /** it maps the ApiResponse Error to the our ErrorResponse class using the mapper. */
            .onError {
                onError(message())
            }
            // handle api request exception
            .onException {
                //for example we can catch connection exception here and do things. right now we are showing toast message.
                onError(message())
            }
    }.flowOn(Dispatchers.IO)

}