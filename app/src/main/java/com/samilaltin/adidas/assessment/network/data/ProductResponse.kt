package com.samilaltin.adidas.assessment.network.data

import android.annotation.SuppressLint
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@SuppressLint("ParcelCreator")
@Parcelize
@JsonClass(generateAdapter = true)
data class ProductResponse(
    @Json(name = "currency") val currency: String?,
    @Json(name = "description") val description: String?,
    @Json(name = "id") val id: String?,
    @Json(name = "imgUrl") val imgUrl: String?,
    @Json(name = "name") val name: String?,
    @Json(name = "price") val price: Int?,
    @Json(name = "reviews") val reviews: List<Review?>?,
    var averageRating: Float?
) : Parcelable {
    fun getPriceWithCurrency(): String {
        return "$currency $price".trim()
    }

    fun getNameWithId(): String {
        return "$name - $id".trim()
    }

    fun getAverageRating(): Float {
        var sum: Double = 0.toDouble()
        var averageRating: Float = 0.toFloat()
        if (reviews?.isNotEmpty() == true) {
            for (i in reviews.indices) {
                sum += reviews[i]?.rating ?: 0
            }
            averageRating = (sum / reviews.size).toFloat()
        }
        return averageRating
    }

    @SuppressLint("ParcelCreator")
    @Parcelize
    @JsonClass(generateAdapter = true)
    data class Review(
        @Json(name = "locale") val locale: String?,
        @Json(name = "productId") val productId: String?,
        @Json(name = "rating") val rating: Int?,
        @Json(name = "text") val text: String?
    ) : Parcelable
}