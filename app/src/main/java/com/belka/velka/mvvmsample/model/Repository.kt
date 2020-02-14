package com.belka.velka.mvvmsample.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.belka.velka.mvvmsample.model.database.JokeDAO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.concurrent.thread

/**
 * site: https://developer.android.com/jetpack/docs/guide#common-principles
 */
class Repository @Inject constructor(private val webservice: API,
                                     private val jokeDAO: JokeDAO) {
    fun getJoke(): LiveData<List<Joke>> {
        webservice.getJokes().enqueue(object : Callback<List<Joke>> {
            override fun onFailure(call: Call<List<Joke>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<Joke>>, response: Response<List<Joke>>) {
                response.body()?.let {
                    thread {
                        jokeDAO.saveAll(it)
                    }
                }
            }
        })

        return jokeDAO.loadAll()
    }
}