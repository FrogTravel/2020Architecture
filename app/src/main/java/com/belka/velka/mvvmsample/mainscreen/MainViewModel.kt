package com.belka.velka.mvvmsample.mainscreen

import androidx.lifecycle.ViewModel
import com.belka.velka.mvvmsample.model.Repository
import com.belka.velka.mvvmsample.model.database.JokeDAO
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: Repository,
    private val jokeDAO: JokeDAO
) : ViewModel() {

    val joke = repository.getJoke()
}