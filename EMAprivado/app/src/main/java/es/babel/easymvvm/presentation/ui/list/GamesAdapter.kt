package es.babel.easymvvm.presentation.ui.list

import android.view.View
import com.bumptech.glide.Glide
import es.babel.domain.model.GameModel
import es.babel.easymvvm.R
import es.babel.easymvvm.android.ui.EmaRecyclerAdapter
import kotlinx.android.synthetic.main.item_games_list.view.*


class GamesAdapter(private val viewModel: GamesListViewModel, override val listItems: MutableList<GameModel>
) : EmaRecyclerAdapter<GameModel>() {
    private var games: List<GameModel> = listItems

    override val layoutItemId: Int? = R.layout.item_games_list

    override fun getItemCount() = games.size

    override fun View.bind(item: GameModel, viewType: Int) {
        tvItemTitle.text = item.title

        item.cover?.let { cover ->
            Glide.with(this).load(cover).into(ivItemCover)
        } ?: Glide.with(this).load(R.drawable.no_cover).into(ivItemCover)

        setOnClickListener {
            viewModel.onGameItemClick(item)
        }
    }
}