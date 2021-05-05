package com.samilaltin.adidas.assessment.ui.productdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.samilaltin.adidas.assessment.R
import com.samilaltin.adidas.assessment.databinding.BottomSheetFragmentAddReviewBinding
import com.samilaltin.adidas.assessment.extension.setSafeOnClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddReviewBottomSheetFragment : BottomSheetDialogFragment() {

    private var sendReviewBottomSheetClickListener: SendReviewBottomSheetClickListener? = null
    lateinit var binding: BottomSheetFragmentAddReviewBinding

    companion object {
        fun newInstance(
            sendReviewBottomSheetClickListener: SendReviewBottomSheetClickListener? = null
        ): AddReviewBottomSheetFragment {
            val fragment = AddReviewBottomSheetFragment()
            fragment.sendReviewBottomSheetClickListener = sendReviewBottomSheetClickListener
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.bottom_sheet_fragment_add_review,
            container,
            false
        )
        binding.apply {
            lifecycleOwner = this@AddReviewBottomSheetFragment
        }
        binding.sendReview.setSafeOnClickListener {
            if (binding.rating.rating < 1 || binding.review.text.isNullOrBlank()) {
                Toast.makeText(context, R.string.fields_required, Toast.LENGTH_SHORT).show()
                return@setSafeOnClickListener
            }
            sendReviewBottomSheetClickListener?.onSendReviewButtonClick(
                binding.rating.rating.toInt(),
                binding.review.text.toString()
            )
            dismiss()
        }
        return binding.root
    }

    interface SendReviewBottomSheetClickListener {
        fun onSendReviewButtonClick(numStars: Int, review: String)
    }
}