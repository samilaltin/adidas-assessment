package com.samilaltin.adidas.assessment.repository

import androidx.annotation.WorkerThread
import com.samilaltin.adidas.assessment.network.AdidasService
import com.samilaltin.adidas.assessment.network.data.ProductResponse
import com.skydoves.sandwich.*
import com.skydoves.sandwich.message
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository @Inject constructor(private val service: AdidasService) {

    @WorkerThread
    suspend fun getProducts(
        onSuccess: (List<ProductResponse>) -> Unit,
        onError: (String) -> Unit
    ) = flow {
        val response = service.getProducts()

        response.suspendOnSuccess {
            data?.let {
                emit(it)
                onSuccess(it)
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