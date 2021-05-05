package com.samilaltin.adidas.assessment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.samilaltin.adidas.assessment.R
import com.samilaltin.adidas.assessment.databinding.ItemProductBinding
import com.samilaltin.adidas.assessment.extension.setSafeOnClickListener
import com.samilaltin.adidas.assessment.network.data.ProductResponse


class ProductListAdapter constructor(
    private val productClickedListener: OnProductClickedListener
) : RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

    private var items: MutableList<ProductResponse> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemProductBinding>(
            inflater,
            R.layout.item_product,
            parent,
            false
        )
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = items[position]
        item.let {
            holder.binding.apply {
                product = it
                ViewCompat.setTransitionName(holder.binding.productImage, it.name)
                root.setSafeOnClickListener { _ ->
                    productClickedListener.onProductClicked(it, holder.binding.productImage)
                }
                executePendingBindings()
            }
        }
    }

    override fun getItemCount(): Int = items.size

    fun addProductList(productList: List<ProductResponse>) {
        items.clear()
        items = productList.toMutableList()
        notifyDataSetChanged()
        // if there would be pagination
        // val previous = items.size
        // items.addAll(productList)
        // notifyItemRangeChanged(previous, productList.size)
    }

    class ProductViewHolder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnProductClickedListener {
        fun onProductClicked(item: ProductResponse, productImage: ImageView)
    }
}