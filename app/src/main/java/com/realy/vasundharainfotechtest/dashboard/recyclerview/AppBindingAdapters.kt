package com.realy.vasundharainfotechtest.dashboard.recyclerview

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object AppBindingAdapters {
    @JvmStatic
    @BindingAdapter("imgUrl")
    fun glide(view: ImageView, url: String?) {
        if (!url.isNullOrEmpty()) {
            Glide.with(view).load(url).into(view)
        }
    }

    fun toFloatVal(str:String):Float{
        return str.toFloatOrNull()?:0.0F
    }
}


