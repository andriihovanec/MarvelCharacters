package com.andriikhovanets.marvelcharacters.data.source

import com.andriikhovanets.marvelcharacters.data.Character
import com.andriikhovanets.marvelcharacters.data.Result
import com.andriikhovanets.marvelcharacters.data.Result.Error
import com.andriikhovanets.marvelcharacters.data.Result.Success

/**
 * Default implementation of [DefaultCharactersRepository]. Single entry point for managing tasks' data.
 */
class DefaultCharactersRepository(
    private val charactersRemoteDataSource: CharactersDataSource
) : CharactersRepository {

    override suspend fun getCharacters(shouldUpdate: Boolean): Result<List<Character>> {
        if (shouldUpdate) {
            try {
                updateCharactersFromRemoteDataSource()
            } catch (ex: Exception) {
                return Error(ex)
            }
        }
        return charactersRemoteDataSource.getCharacters()
    }

    private suspend fun updateCharactersFromRemoteDataSource() {
        val remoteCharacters = charactersRemoteDataSource.getCharacters()

        if (remoteCharacters is Success) {
            remoteCharacters.data.forEach {
                // save to local data source
            }
        } else if (remoteCharacters is Error) {
            throw remoteCharacters.exception
        }
    }
}