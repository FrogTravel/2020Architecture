package com.belka.velka.mvvmsample.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Joke(
    val site: String,
    val name: String,
    val desc: String,
    val link: String?,
    @PrimaryKey val elementPureHtml: String
)