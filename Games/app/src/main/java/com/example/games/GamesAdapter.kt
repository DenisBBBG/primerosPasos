package com.example.games

import android.provider.Settings.System.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item.view.*


class GamesAdapter(private val allGames: List<Game>, private val listener: (Game) -> Unit) :
    RecyclerView.Adapter<GamesViewHolder>() {

    private var games = allGames

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return GamesViewHolder(view, listener)
    }

    override fun getItemCount() = games.size

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) =
        holder.bind(games[position])


    fun filterGames(filter: String) {
        games = allGames
        games.filter { game ->
            game.title?.contains(filter, ignoreCase = true) ?: false
        }
        notifyDataSetChanged()
    }
}

class GamesViewHolder(itemView: View, private val listener: (Game) -> Unit) :
    RecyclerView.ViewHolder(itemView) {

    fun bind(game: Game) {
        itemView.tvItemTitle.text = game.title

        game.cover?.let { cover ->
            Glide.with(itemView).load(cover).into(itemView.ivItemCover)
        } ?: Glide.with(itemView).load(R.drawable.no_cover).into(itemView.ivItemCover)

        itemView.setOnClickListener {
            listener.invoke(game)
        }

    }


}


