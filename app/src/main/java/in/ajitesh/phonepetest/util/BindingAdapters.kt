package `in`.ajitesh.phonepetest.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

sealed class BindingAdapters {

    companion object {

        @JvmStatic
        @BindingAdapter("img_url")
        fun setImageUrl(imageView: ImageView, url: String?) {
            Glide.with(imageView.context)
                .load(url)
                .into(imageView)

        }

        @JvmStatic
        @BindingAdapter("points")
        fun setImageUrl(textView: TextView, points: Integer?) {
            textView.text = (points ?: 0).toString()

        }
    }
}