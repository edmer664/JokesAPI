package com.edmer.jokesapi.network

import retrofit2.Call
import retrofit2.http.GET

interface JokeInterface {
    @GET("joke/Any?type=single")
    fun getJoke(): Call<JokeData>
}