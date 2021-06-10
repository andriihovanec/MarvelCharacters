package com.andriikhovanets.marvelcharacters.remote

import com.andriikhovanets.marvelcharacters.Constants.BASE_URL
import com.andriikhovanets.marvelcharacters.Constants.MD5
import com.andriikhovanets.marvelcharacters.Constants.PUBLIC_KEY
import com.andriikhovanets.marvelcharacters.Constants.TIMESTAMP
import com.andriikhovanets.marvelcharacters.data.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkService {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(ApiService::class.java)

    suspend fun allCharacters(): List<Character>? = withContext(Dispatchers.Default) {
        val result = apiService.getCharacters(PUBLIC_KEY, TIMESTAMP, MD5)
        if (result.isSuccessful && result.body() != null) {
            result.body()!!.data.results
        } else {
            null
        }
    }
}