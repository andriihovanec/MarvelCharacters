package com.andriikhovanets.marvelcharacters.remote

import com.andriikhovanets.marvelcharacters.data.CharacterDataWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("characters")
    suspend fun getCharacters(
        @Query("apikey") apikey: String,
        @Query("ts") timestamp: String,
        @Query("hash") hash: String
    ): Response<CharacterDataWrapper>
}