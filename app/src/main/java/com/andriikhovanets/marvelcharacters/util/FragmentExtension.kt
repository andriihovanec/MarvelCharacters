package com.andriikhovanets.marvelcharacters.util

import androidx.fragment.app.Fragment
import com.andriikhovanets.marvelcharacters.App
import com.andriikhovanets.marvelcharacters.ViewModelFactory

fun Fragment.getViewModelFactory(): ViewModelFactory {
    val repository = (requireContext().applicationContext as App).charactersRepository
    return ViewModelFactory(repository, this)
}