package com.belka.velka.mvvmsample.mainscreen

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.belka.velka.mvvmsample.R
import com.belka.velka.mvvmsample.model.Joke
import kotlinx.android.synthetic.main.joke_card.view.*

class JokeAdapter(val jokes: List<Joke>) : RecyclerView.Adapter<JokeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.joke_card, null))
    }

    override fun getItemCount() = jokes.size

    override fun onBindViewHolder(viewHolder: ViewHolder, id: Int) {
        viewHolder.view.textView.text = jokes[id].elementPureHtml
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}