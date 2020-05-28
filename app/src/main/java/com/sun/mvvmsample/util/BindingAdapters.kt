package com.sun.mvvmsample.util

import android.animation.ObjectAnimator
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.GenericTransitionOptions
import com.bumptech.glide.Glide

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(imageView: ImageView, url: String) {
        Glide.with(imageView.context)
            .load(url)
            .transition(GenericTransitionOptions.with { view ->
                val fadeAnim = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)
                fadeAnim.duration = 500
                fadeAnim.start()
            })
            .into(imageView)
    }
}
