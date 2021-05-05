package com.samilaltin.adidas.assessment.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.annotation.VisibleForTesting
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import com.samilaltin.adidas.assessment.R
import com.samilaltin.adidas.assessment.base.DataBindingActivity
import com.samilaltin.adidas.assessment.databinding.ActivityMainBinding
import com.samilaltin.adidas.assessment.network.data.ProductResponse
import com.samilaltin.adidas.assessment.ui.adapter.ProductListAdapter
import com.samilaltin.adidas.assessment.ui.productdetail.ProductDetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : DataBindingActivity() {

    companion object {
        @VisibleForTesting
        const val EXTRA_PRODUCT = "EXTRA_PRODUCT"
        const val EXTRA_PRODUCT_IMAGE_TRANSITION_NAME = "EXTRA_PRODUCT_IMAGE_TRANSITION_NAME"
    }

    @VisibleForTesting
    val mainViewModel: MainViewModel by viewModels()
    private val binding: ActivityMainBinding by binding(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            lifecycleOwner = this@MainActivity
            adapter = ProductListAdapter(object : ProductListAdapter.OnProductClickedListener {
                override fun onProductClicked(item: ProductResponse, productImage: ImageView) {
                    startActivityWithTransitionAnimation(item, productImage)
                }
            })
            viewModel = mainViewModel
        }
    }

    private fun startActivityWithTransitionAnimation(
        item: ProductResponse,
        productImage: ImageView
    ) {
        val intent = Intent(this@MainActivity, ProductDetailActivity::class.java)
        intent.putExtra(EXTRA_PRODUCT, item)
        intent.putExtra(
            EXTRA_PRODUCT_IMAGE_TRANSITION_NAME,
            ViewCompat.getTransitionName(productImage)
        )
        val options: ActivityOptionsCompat? =
            ViewCompat.getTransitionName(productImage)?.let {
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this@MainActivity,
                    productImage,
                    it
                )
            }
        startActivity(intent, options?.toBundle())
    }
}