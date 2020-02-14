package com.belka.velka.mvvmsample.model.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.belka.velka.mvvmsample.model.Joke

@Dao
interface JokeDAO {
    @Insert(onConflict = REPLACE)
    fun save(joke: Joke)

    @Query("SELECT * FROM joke")
    fun loadAll(): LiveData<Joke>
}