package com.andriikhovanets.marvelcharacters.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.andriikhovanets.marvelcharacters.R
import com.andriikhovanets.marvelcharacters.databinding.FragmentCharactersBinding
import com.andriikhovanets.marvelcharacters.util.getViewModelFactory

class CharactersFragment : Fragment(R.layout.fragment_characters) {

    private val binding: FragmentCharactersBinding by viewBinding()
    private val charactersViewModel by viewModels<CharactersViewModel> { getViewModelFactory() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        charactersViewModel.loadCharacters()
    }
}