package com.andriikhovanets.marvelcharacters.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.andriikhovanets.marvelcharacters.R
import com.andriikhovanets.marvelcharacters.data.CharactersRepository
import com.andriikhovanets.marvelcharacters.databinding.FragmentCharactersBinding
import com.andriikhovanets.marvelcharacters.utils.Injector
import com.google.android.material.snackbar.Snackbar

class CharactersFragment : Fragment(R.layout.fragment_characters) {

    private val binding: FragmentCharactersBinding by viewBinding()
    private val charactersViewModel: CharactersViewModel by viewModels {
        Injector.provideCharactersViewModelFactory(requireContext())
    }

    private val charactersAdapter = CharacterAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        charactersViewModel.loadCharacters()
        subscribeUi()
        handleProgress()
        handleErrors()
    }

    private fun subscribeUi() {
        charactersViewModel.characters.observe(viewLifecycleOwner) { characters ->
            binding.rvCharacters.adapter = charactersAdapter
            charactersAdapter.submitList(characters)
        }
    }

    private fun handleProgress() {
        charactersViewModel.spinner.observe(viewLifecycleOwner) { show ->
            binding.spinner.visibility = if (show) View.VISIBLE else View.GONE
        }
    }

    private fun handleErrors() {
        // Show a snackbar whenever the [snackbar] is updated a non-null value
        charactersViewModel.snackbar.observe(viewLifecycleOwner) { text ->
            text?.let {
                Snackbar.make(binding.root, text, Snackbar.LENGTH_SHORT).show()
                charactersViewModel.onSnackbarShown()
            }
        }
    }
}

/**
 * Factory for creating a [CharactersViewModel] with a constructor that takes a [CharactersRepository].
 */
class CharactersViewModelFactory(
    private val repository: CharactersRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        CharactersViewModel(repository) as T
}