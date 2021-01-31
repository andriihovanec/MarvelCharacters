package com.andriikhovanets.marvelcharacters.remote

import com.andriikhovanets.marvelcharacters.data.Character
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("comics")
    fun getComics(
        @Query("apikey") apikey: String,
        @Query("ts") timestamp: String,
        @Query("hash") hash: String
    )

    @GET("comics")
    fun getCharacters(
        @Query("apikey") apikey: String,
        @Query("ts") timestamp: String,
        @Query("hash") hash: String
    ): Call<List<Character>>
}