package com.belka.velka.mvvmsample.model

import retrofit2.Call
import retrofit2.http.GET

interface API{
    @GET("get")
    fun getJokes() : Call<List<Joke>>
}