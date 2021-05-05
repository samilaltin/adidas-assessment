package com.samilaltin.adidas.assessment.network

import com.samilaltin.adidas.assessment.network.data.ReviewRequest
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AdidasReviewService {
    @POST("/reviews/{productId}")
    suspend fun postReview(
        @Path("productId") productId: String?,
        @Body reviewRequest: ReviewRequest
    ): ApiResponse<*>

    //This method should be used if you want to view comments on port 3002. Currently showing comments returning from port 3001 with sharing reviews
    @GET("/reviews/{productId}")
    suspend fun getReviews(
        @Path("productId") productId: String?
    ): ApiResponse<List<ReviewRequest>>
}