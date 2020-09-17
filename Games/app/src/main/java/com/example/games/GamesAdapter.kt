package com.example.games

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


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
    private var imagen: ImageView = itemView.findViewById(R.id.fragmentInicioCaratula)
    fun bind(game: JuegosItem) {
        title.text = game.name
        Glide.with(itemView.context).load("https://api-v3.igdb.com/t/p/w500/games/39903").into(imagen)

    }
}