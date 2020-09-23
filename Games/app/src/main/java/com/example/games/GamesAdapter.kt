package com.example.games

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide



class GamesAdapter(val games: List<JuegosItem>, private val listener: (JuegosItem) -> Unit): RecyclerView.Adapter<GamesViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return GamesViewHolder(view)
    }
    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        holder.itemView.setOnClickListener{listener(games[position])
        }
        return holder.bind(games[position])
    }
}

class GamesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    private val title: TextView = itemView.findViewById(R.id.fragmentoDatosTitulo)
    private var imagen: ImageView = itemView.findViewById(R.id.fragmentInicioCaratula)
    fun bind(game: JuegosItem) {

        title.text = game.name

        if(!game?.coverURL.equals("sinURL")){
            Glide.with(itemView.context).load("https:"+ game?.coverURL).into(imagen)
        }else{
            Glide.with(itemView.context).load(R.mipmap.sin_imagen).into(imagen)
        }
    }
}


