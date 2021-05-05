package com.samilaltin.adidas.assessment.network.data

import android.annotation.SuppressLint
import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
@JsonClass(generateAdapter = true)
data class ReviewRequest(
    @Json(name = "locale") val locale: String?,
    @Json(name = "productId") val productId: String?,
    @Json(name = "rating") val rating: Int?,
    @Json(name = "text") val text: String?
) : Parcelable