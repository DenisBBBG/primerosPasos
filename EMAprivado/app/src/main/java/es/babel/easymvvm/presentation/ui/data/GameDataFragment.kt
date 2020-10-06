package es.babel.easymvvm.presentation.ui.data

import es.babel.easymvvm.R
import es.babel.easymvvm.core.navigator.EmaBaseNavigator
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.easymvvm.presentation.base.BaseFragment
import es.babel.easymvvm.presentation.ui.list.GamesListNavigator
import kotlinx.android.synthetic.main.fragment_game_data.*
import org.kodein.di.generic.instance

class GameDataFragment() : BaseFragment<GameDataState, GameDataViewModel, GameDataNavigator.Navigation>() {


    override val layoutId: Int = R.layout.fragment_game_data
    override val viewModelSeed: GameDataViewModel by instance()
    override val navigator: EmaBaseNavigator<GameDataNavigator.Navigation>? by instance()
    override fun onNormal(data: GameDataState) {

        tvGameDataTitle.text = data.game?.title
    }

    override fun onAlternative(data: EmaExtraData) {
    }

    override fun onSingle(data: EmaExtraData) {
    }

    override fun onError(error: Throwable) {
    }

    override fun onInitialized(viewModel: GameDataViewModel) {
    }
/*

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { arg ->
            val game = arg.getSerializable(es.babel.data.model.GameModel::class.java.name) as es.babel.data.model.GameModel
            tvGameDataTitle.text = game.title
            if (game.summary.isNullOrEmpty()) {
                tvGameDataSummary.text = getString(R.string.games_data_no_description)
            } else {
                tvGameDataSummary.text = game.summary
            }
            tvGameDataURL.text = game.url
            tvGameDataChecksum.text = game.checksum

            game.cover?.let { cover ->
                Glide.with(view).load(cover).into(ivGameDataCover)
            } ?: Glide.with(view).load(R.drawable.no_cover).into(ivGameDataCover)

        }


 */

}


