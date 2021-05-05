package com.samilaltin.adidas.assessment.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.samilaltin.adidas.assessment.network.data.ProductResponse
import com.samilaltin.adidas.assessment.ui.adapter.ProductListAdapter
import com.samilaltin.adidas.assessment.ui.adapter.ProductReviewListAdapter

object RecyclerViewBinding {


    @JvmStatic
    @BindingAdapter(value = ["productListAdapter", "adapterProductList"])
    fun bindAdapterProductList(
        view: RecyclerView,
        productListAdapter: ProductListAdapter,
        productList: List<ProductResponse>?
    ) {
        if (productList.isNullOrEmpty()) {
            return
        }
        view.adapter = productListAdapter
        (view.adapter as? ProductListAdapter)?.addProductList(productList)
    }

    @JvmStatic
    @BindingAdapter(value = ["reviewListAdapter", "adapterProductReviewList"])
    fun bindAdapterProductReviewList(
        view: RecyclerView,
        reviewListAdapter: ProductReviewListAdapter,
        reviewList: List<ProductResponse.Review>?
    ) {
        if (reviewList.isNullOrEmpty()) {
            return
        }
        view.adapter = reviewListAdapter
        (view.adapter as? ProductReviewListAdapter)?.addProductReviewList(reviewList)
    }
}