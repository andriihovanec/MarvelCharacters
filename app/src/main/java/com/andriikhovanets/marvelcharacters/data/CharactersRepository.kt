package com.andriikhovanets.marvelcharacters.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.andriikhovanets.marvelcharacters.remote.NetworkService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class CharactersRepository(
    private val service: NetworkService,
    private val characterDao: CharacterDao,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) {

    val characters: LiveData<List<Character>> = liveData {
        val characterLiveData = characterDao.getCharacters()
        emitSource(characterLiveData)
    }

    private fun shouldUpdateCharactersCache(): Boolean {
        return true
    }

    suspend fun tryUpdateRecentPlantsCache() {
        if (shouldUpdateCharactersCache()) fetchRecentCharacter()
    }

    private suspend fun fetchRecentCharacter() {
        val characters = service.allCharacters()
        characters?.let { characterDao.insertAll(it) }
    }

    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: CharactersRepository? = null

        fun getInstance(characterDao: CharacterDao, service: NetworkService) =
            instance ?: synchronized(this) {
                instance ?: CharactersRepository(service, characterDao).also { instance = it }
            }
    }
}