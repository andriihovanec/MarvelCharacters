package com.andriikhovanets.marvelcharacters.data.source

import com.andriikhovanets.marvelcharacters.data.Character
import com.andriikhovanets.marvelcharacters.data.Result

/**
 * Interface to the data layer.
 */
interface CharactersRepository {

    suspend fun getCharacters(shouldUpdate: Boolean = false): Result<List<Character>>
}