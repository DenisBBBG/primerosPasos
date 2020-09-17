package com.example.games

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class GamesAdapter(val games: List<com.example.games.JuegosItem>): RecyclerView.Adapter<GamesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return GamesViewHolder(view)
    }
    override fun getItemCount(): Int {
        return games.size
    }
    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        return holder.bind(games[position])
    }

}

class GamesViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
    private val title: TextView = itemView.findViewById(R.id.fragmentInicioTitulo)

    fun bind(game: JuegosItem) {
        title.text = "Title: "+game.name

    }
}