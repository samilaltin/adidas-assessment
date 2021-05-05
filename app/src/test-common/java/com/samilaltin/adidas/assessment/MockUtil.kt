package com.samilaltin.adidas.assessment

import com.samilaltin.adidas.assessment.network.data.ProductResponse

object MockUtil {

    fun mockProducts() = listOf(mockProduct())
    private fun mockProduct() = ProductResponse(
        currency = "",
        price = 0,
        id = "FI444",
        name = "product",
        description = "description",
        imgUrl = "https://assets.adidas.com/images/w_320,h_320,f_auto,q_auto:sensitive,fl_lossy/6634cf36274b4ea5ac46ac4e00b2021e_9366/Superstar_Shoes_Black_FY0071_01_standard.jpg",
        reviews = mockReviews(),
        averageRating = 0f
    )

    private fun mockReviews() = listOf(mockReview())
    private fun mockReview() = ProductResponse.Review(
        locale = "en-US",
        productId = "FI444",
        rating = 3,
        text = "this product is the bestaaaa"
    )
}