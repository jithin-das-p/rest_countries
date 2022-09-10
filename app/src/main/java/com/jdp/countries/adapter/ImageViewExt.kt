package com.jdp.countries.adapter

import android.widget.ImageView
import android.net.Uri
import androidx.databinding.BindingAdapter
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.jdp.countries.R

@BindingAdapter("app:loadSvg")
fun ImageView.loadSvg(url: String?) {
    GlideToVectorYou
        .init()
        .with(context)
        .setPlaceHolder(R.drawable.progress_animation, R.drawable.loading_error)
        .load(Uri.parse(url), this)
}
