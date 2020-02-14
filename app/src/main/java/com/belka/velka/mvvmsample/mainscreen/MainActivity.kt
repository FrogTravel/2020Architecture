package com.belka.velka.mvvmsample.mainscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.belka.velka.mvvmsample.BaseApp
import com.belka.velka.mvvmsample.R
import com.belka.velka.mvvmsample.model.Joke
import com.belka.velka.mvvmsample.model.Repository
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var repository: Repository
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun onCreate(savedInstanceState: Bundle?) {
        (application as BaseApp).appComponent.inject(this)
        super.onCreate(savedInstanceState)

        val model: MainViewModel = ViewModelProvider(this, viewModelFactory).get(
            MainViewModel::class.java
        )
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)

        model.joke.observe(this,
            Observer<List<Joke>> { t ->
                t?.let {
                    recyclerView.adapter = JokeAdapter(it)
                }
            })
    }
}
