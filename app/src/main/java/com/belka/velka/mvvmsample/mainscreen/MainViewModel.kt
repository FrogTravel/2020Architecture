package com.belka.velka.mvvmsample.mainscreen

import androidx.lifecycle.ViewModel
import com.belka.velka.mvvmsample.model.Repository
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val joke = repository.getJoke()
}