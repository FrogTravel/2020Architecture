package com.belka.velka.mvvmsample.dagger

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val applicationContext: Context){
    @Provides
    fun getApplicationContext() : Context = applicationContext
}