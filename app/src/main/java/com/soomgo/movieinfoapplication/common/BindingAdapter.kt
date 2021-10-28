package com.soomgo.movieinfoapplication.common

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("android:setImageUrl")
fun setImage(view : ImageView, url : String?){
    url?.let {
        Glide.with(view).load(ImageUrl+url).centerCrop().into(view)
    }
}

@BindingAdapter("android:formatNumer")
fun setFormatNubmer(view : TextView, amount : Double){
    val formatNumber = amount.toString()
    view.text = formatNumber
}

@BindingAdapter("android:setRunningTime")
fun setRunningTime(view : TextView, time : Int){
    val runningTime = if(time > 1){
        "$time mins"
    } else{
        "$time min"
    }

    view.text = runningTime

}

@BindingAdapter("android:setFavoriteMovie")
fun setFavoriteMovie(view : ImageView, isFavorite : Boolean){
    view.setImageResource(
        when(isFavorite){
            true -> android.R.drawable.star_on
            false -> android.R.drawable.star_off
        }
    )
}