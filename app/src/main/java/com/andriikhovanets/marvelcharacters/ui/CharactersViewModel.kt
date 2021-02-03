package com.andriikhovanets.marvelcharacters.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andriikhovanets.marvelcharacters.data.Character
import com.andriikhovanets.marvelcharacters.data.CharactersRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val repository: CharactersRepository
) : ViewModel() {

    private val _snackbar = MutableLiveData<String?>()
    val snackbar: LiveData<String?>
        get() = _snackbar

    private val _spinner = MutableLiveData(false)
    val spinner: LiveData<Boolean>
        get() = _spinner

    val characters: LiveData<List<Character>> = repository.characters

    fun onSnackbarShown() {
        _snackbar.value = null
    }

    fun loadCharacters() {
        launchDataLoad { repository.tryUpdateRecentPlantsCache() }
    }

    private fun launchDataLoad(block: suspend () -> Unit): Job {
        return viewModelScope.launch {
            try {
                _spinner.value = true
                block()
            } catch (error: Throwable) {
                _snackbar.value = error.message
            } finally {
                _spinner.value = false
            }
        }
    }
}