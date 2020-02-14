package com.belka.velka.mvvmsample.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.belka.velka.mvvmsample.mainscreen.MainViewModel
import com.belka.velka.mvvmsample.model.Repository
import com.belka.velka.mvvmsample.model.database.JokeDAO
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {
    @Provides
    fun getViewModelFactory(repository: Repository, jokeDAO: JokeDAO) : ViewModelProvider.Factory = object : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(repository, jokeDAO) as T
        }

    }

}