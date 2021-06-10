package com.andriikhovanets.marvelcharacters.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.andriikhovanets.marvelcharacters.data.Character
import com.andriikhovanets.marvelcharacters.ui.CharacterAdapter

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    val disposable = imgView.load(imgUrl)
    //disposable.dispose()
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Character>?) {
    val adapter = recyclerView.adapter as CharacterAdapter?
    adapter?.submitList(data)
}