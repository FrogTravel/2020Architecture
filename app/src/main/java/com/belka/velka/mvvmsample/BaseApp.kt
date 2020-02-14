package com.belka.velka.mvvmsample

import android.app.Application
import com.belka.velka.mvvmsample.dagger.ApplicationComponent
import com.belka.velka.mvvmsample.dagger.ApplicationModule
import com.belka.velka.mvvmsample.dagger.DaggerApplicationComponent
import com.belka.velka.mvvmsample.dagger.NetModule

class BaseApp : Application() {
    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(applicationContext)).build()
    }
}