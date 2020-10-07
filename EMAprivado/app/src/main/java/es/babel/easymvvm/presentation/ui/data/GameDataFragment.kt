package es.babel.easymvvm.presentation.ui.data

import com.bumptech.glide.Glide
import es.babel.easymvvm.R
import es.babel.easymvvm.core.navigator.EmaBaseNavigator
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.easymvvm.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_game_data.*
import org.kodein.di.generic.instance

class GameDataFragment : BaseFragment<GameDataState, GameDataViewModel, GameDataNavigator.Navigation>() {
    private lateinit var viewModel: GameDataViewModel

    override val layoutId: Int = R.layout.fragment_game_data

    override val viewModelSeed: GameDataViewModel by instance()

    override val navigator: EmaBaseNavigator<GameDataNavigator.Navigation>? by instance()

    override fun onNormal(data: GameDataState) {

        data.game?.let {
            tvGameDataTitle.text = it.title

            if (it.summary.isNullOrEmpty())
                tvGameDataSummary.text = getString(R.string.games_data_no_description)
            else
                tvGameDataSummary.text = it.summary

            tvGameDataURL.text = it.url
            tvGameDataChecksum.text = it.checksum

            it.cover?.let { cover ->
                view?.let { it1 -> Glide.with(it1).load(cover).into(ivGameDataCover) }
            }
                    ?: view?.let { it1 -> Glide.with(it1).load(R.drawable.no_cover).into(ivGameDataCover) }
        }

    }

    override fun onAlternative(data: EmaExtraData) {
    }

    override fun onSingle(data: EmaExtraData) {
    }

    override fun onError(error: Throwable) {
    }

    override fun onInitialized(viewModel: GameDataViewModel) {
        this.viewModel = viewModel
    }
}
