package com.belka.velka.mvvmsample.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.belka.velka.mvvmsample.model.Joke

@Database(entities = [Joke::class], version = 1)
abstract class JokeDatabase : RoomDatabase() {
    abstract fun jokeDao(): JokeDAO
}