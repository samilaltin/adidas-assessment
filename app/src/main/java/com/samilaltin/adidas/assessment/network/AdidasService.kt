package com.samilaltin.adidas.assessment.network

import com.samilaltin.adidas.assessment.network.data.ProductResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface AdidasService {
    @GET("/product")
    suspend fun getProducts(): ApiResponse<List<ProductResponse>>
}