package com.belka.velka.mvvmsample.dagger

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.belka.velka.mvvmsample.model.database.JokeDAO
import com.belka.velka.mvvmsample.model.database.JokeDatabase
import dagger.Module
import dagger.Provides

@Module
class DBModule {
    @Provides
    fun getDatabaseJoke(context: Context): JokeDatabase {
        return Room.databaseBuilder(context, JokeDatabase::class.java, "joke")
            .setJournalMode(RoomDatabase.JournalMode.TRUNCATE)
            .build()
    }

    @Provides
    fun getDaoJoke(jokeDatabase: JokeDatabase): JokeDAO = jokeDatabase.jokeDao()
}