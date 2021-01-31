package com.andriikhovanets.marvelcharacters.ui

import androidx.lifecycle.ViewModel
import com.andriikhovanets.marvelcharacters.data.source.CharactersRepository
import java.math.BigInteger
import java.security.MessageDigest

class CharactersViewModel(
    private val charactersRepository: CharactersRepository
) : ViewModel() {

    fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }

    fun loadCharacters() {

    }
}