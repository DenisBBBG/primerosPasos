package es.babel.easymvvm.presentation.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import es.babel.domain.model.GameModel
import es.babel.easymvvm.R
import kotlinx.android.synthetic.main.item_games_list.view.*


class GamesAdapter(
        private val allGameModels: List<GameModel>,
        private val viewModel: GamesListViewModel
) :
        RecyclerView.Adapter<GamesViewHolder>() {

    private var games = allGameModels

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_games_list, parent, false)
        return GamesViewHolder(view, viewModel)
    }

    override fun getItemCount() = games.size

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) =
            holder.bind(games[position])

    fun filterGames(filter: String) {
        games = allGameModels.filter { game ->
            game.title?.contains(filter, ignoreCase = true) ?: false
        }
        notifyDataSetChanged()
    }

}

class GamesViewHolder(itemView: View, private val viewModel: GamesListViewModel) :
        RecyclerView.ViewHolder(itemView) {

    fun bind(gameModel: GameModel) {
        itemView.tvItemTitle.text = gameModel.title
        gameModel.cover?.let { cover ->
            Glide.with(itemView).load(cover).into(itemView.ivItemCover)
        } ?: Glide.with(itemView).load(R.drawable.no_cover).into(itemView.ivItemCover)

        itemView.ivItemFrame.setImageResource(R.drawable.item_frame)

        itemView.setOnClickListener {
            viewModel.onGameItemClick(gameModel)
        }

    }


}


