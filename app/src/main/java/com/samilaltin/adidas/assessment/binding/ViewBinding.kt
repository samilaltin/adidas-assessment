package com.samilaltin.adidas.assessment.binding

import android.view.View
import android.widget.RatingBar
import android.widget.Toast
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.BindingAdapter
import androidx.fragment.app.FragmentManager
import com.samilaltin.adidas.assessment.extension.setSafeOnClickListener
import com.samilaltin.adidas.assessment.ui.productdetail.AddReviewBottomSheetFragment

object ViewBinding {

    @JvmStatic
    @BindingAdapter("toast")
    fun bindToast(view: View, text: String?) {
        text?.let {
            Toast.makeText(view.context, it, Toast.LENGTH_SHORT).show()
        }
    }

    @JvmStatic
    @BindingAdapter("gone")
    fun bindGone(view: View, shouldBeGone: Boolean) {
        view.visibility = if (shouldBeGone) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }

    @JvmStatic
    @BindingAdapter("onBackPressed")
    fun bindOnBackPressed(view: View, onBackPress: Boolean) {
        val context = view.context
        if (onBackPress && context is OnBackPressedDispatcherOwner) {
            view.setOnClickListener {
                context.onBackPressedDispatcher.onBackPressed()
            }
        }
    }

    @JvmStatic
    @BindingAdapter("visibleIf")
    fun changeVisibility(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter("setRating")
    fun setRating(ratingBar: RatingBar, rating: Float) {
        ratingBar.rating = rating
    }

    @JvmStatic
    @BindingAdapter(value = ["reviewClickListener", "fragmentManager"])
    fun setReviewClickListener(
        view: AppCompatButton?,
        listener: AddReviewBottomSheetFragment.SendReviewBottomSheetClickListener,
        supportFragmentManager: FragmentManager
    ) {
        view?.setSafeOnClickListener {
            AddReviewBottomSheetFragment
                .newInstance(listener)
                .show(supportFragmentManager, "AddReviewBottomSheetFragment")
        }
    }

}