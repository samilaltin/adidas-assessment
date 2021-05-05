package com.samilaltin.adidas.assessment.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.samilaltin.adidas.assessment.R
import com.samilaltin.adidas.assessment.extension.loadImageCenterCrop
import com.samilaltin.adidas.assessment.extension.resDrawable

object ImageBindingAdapter {
    @JvmStatic
    @BindingAdapter("setImageCenterCrop")
    fun setImageCenterCrop(view: ImageView, url: String?) {
        url?.let {
            view.loadImageCenterCrop(it, view.resDrawable(R.drawable.ic_noimage))
        }
    }

    @JvmStatic
    @BindingAdapter("setTransitionName")
    fun setTransitionName(view: ImageView, transitionName: String?) {
        transitionName?.let {
            view.transitionName = transitionName
        }
    }
}