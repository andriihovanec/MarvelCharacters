package com.andriikhovanets.marvelcharacters.utils

import android.content.Context
import com.andriikhovanets.marvelcharacters.data.AppDatabase
import com.andriikhovanets.marvelcharacters.data.CharactersRepository
import com.andriikhovanets.marvelcharacters.remote.NetworkService
import com.andriikhovanets.marvelcharacters.ui.CharactersViewModelFactory

interface ViewModelFactoryProvider {
    fun provideCharactersViewModelFactory(context: Context): CharactersViewModelFactory
}
val Injector: ViewModelFactoryProvider
    get() = currentInjector

private object DefaultViewModelProvider: ViewModelFactoryProvider {
    private fun getCharactersRepository(context: Context): CharactersRepository {
        return CharactersRepository.getInstance(
            characterDao(context),
            service())
    }

    private fun service() = NetworkService()

    private fun characterDao(context: Context) =
        AppDatabase.getInstance(context.applicationContext).characterDao()

    override fun provideCharactersViewModelFactory(context: Context): CharactersViewModelFactory {
        val repository = getCharactersRepository(context)
        return CharactersViewModelFactory(repository)
    }
}

@Volatile private var currentInjector: ViewModelFactoryProvider = DefaultViewModelProvider