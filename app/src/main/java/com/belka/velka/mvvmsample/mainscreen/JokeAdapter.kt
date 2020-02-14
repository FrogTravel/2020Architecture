package com.belka.velka.mvvmsample.mainscreen

import android.os.Build
import android.text.Html
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            viewHolder.view.textView.text = Html.fromHtml(jokes[id].elementPureHtml, Html.FROM_HTML_MODE_COMPACT)
        }else{
            viewHolder.view.textView.text = Html.fromHtml(jokes[id].elementPureHtml)
        }

        viewHolder.view.textViewName.text = jokes[id].name.capitalize()
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}