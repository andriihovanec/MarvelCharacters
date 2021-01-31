package com.andriikhovanets.marvelcharacters.data.source.remote

import androidx.lifecycle.LiveData
import com.andriikhovanets.marvelcharacters.data.Character
import com.andriikhovanets.marvelcharacters.data.Result
import com.andriikhovanets.marvelcharacters.data.source.CharactersDataSource
import com.andriikhovanets.marvelcharacters.remote.ApiService

class CharactersRemoteDataSource(
    private val apiService: ApiService
) : CharactersDataSource {

    override fun observeCharacters(): LiveData<Result<List<Character>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCharacters(): Result<List<Character>> {
        return apiService.getComics()
    }
}