package com.samilaltin.adidas.assessment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.samilaltin.adidas.assessment.R
import com.samilaltin.adidas.assessment.databinding.ItemReviewBinding
import com.samilaltin.adidas.assessment.network.data.ProductResponse

class ProductReviewListAdapter : RecyclerView.Adapter<ProductReviewListAdapter.ReviewViewHolder>() {

    private var items: MutableList<ProductResponse.Review> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemReviewBinding>(
            inflater,
            R.layout.item_review,
            parent,
            false
        )
        return ReviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val item = items[position]
        item.let {
            holder.binding.apply {
                review = it
                executePendingBindings()
            }
        }
    }

    override fun getItemCount(): Int = items.size

    fun addProductReviewList(reviewList: List<ProductResponse.Review>) {
        items = reviewList.toMutableList()
        notifyDataSetChanged()
    }

    class ReviewViewHolder(val binding: ItemReviewBinding) : RecyclerView.ViewHolder(binding.root)
}