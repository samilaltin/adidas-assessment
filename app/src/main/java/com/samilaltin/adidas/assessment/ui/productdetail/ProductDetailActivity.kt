package com.samilaltin.adidas.assessment.ui.productdetail

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.annotation.VisibleForTesting
import androidx.recyclerview.widget.DividerItemDecoration
import com.samilaltin.adidas.assessment.R
import com.samilaltin.adidas.assessment.base.DataBindingActivity
import com.samilaltin.adidas.assessment.databinding.ActivityProductDetailBinding
import com.samilaltin.adidas.assessment.extension.setSafeOnClickListener
import com.samilaltin.adidas.assessment.ui.adapter.ProductReviewListAdapter
import com.samilaltin.adidas.assessment.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailActivity : DataBindingActivity() {

    @VisibleForTesting
    val productDetailViewModel: ProductDetailViewModel by viewModels()
    private val binding: ActivityProductDetailBinding by binding(R.layout.activity_product_detail)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            lifecycleOwner = this@ProductDetailActivity
            product = intent.extras?.getParcelable(MainActivity.EXTRA_PRODUCT)
            productDetailViewModel.productId = product?.id
            adapter = ProductReviewListAdapter()
            binding.reviewsRecyclerView.addItemDecoration(
                DividerItemDecoration(
                    this@ProductDetailActivity,
                    LinearLayout.VERTICAL
                )
            )
            initView()
            viewModel = productDetailViewModel
        }
    }

    private fun initView() {
        setImageTransitionName()
        setAddReviewButton()
    }

    private fun setAddReviewButton() {
        binding.fragmentManager = supportFragmentManager
    }

    private fun setImageTransitionName() {
        val imageTransitionName: String? =
            intent.extras?.getString(MainActivity.EXTRA_PRODUCT_IMAGE_TRANSITION_NAME)
        binding.productImage.transitionName = imageTransitionName
    }
}