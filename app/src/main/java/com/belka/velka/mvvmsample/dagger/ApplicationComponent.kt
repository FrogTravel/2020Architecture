package com.belka.velka.mvvmsample.dagger

import com.belka.velka.mvvmsample.mainscreen.MainActivity
import dagger.Component

@Component(modules = [NetModule::class, ViewModelModule::class, DBModule::class, ApplicationModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}