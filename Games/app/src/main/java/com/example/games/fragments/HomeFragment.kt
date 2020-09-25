package com.example.games.fragments

import android.os.Bundle
import android.view.*
import android.view.contentcapture.ContentCaptureContext
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.games.Game
import com.example.games.GameListViewModel
import com.example.games.GamesAdapter
import com.example.games.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import okhttp3.internal.notify
import okhttp3.internal.wait
import kotlin.coroutines.EmptyCoroutineContext

/*
Fragment que se carga al iniciar la aplicacion. En este fragment estoy
cargando dos listas, una con objetos para cada imagen y otra para cada juego.
 */
class HomeFragment : Fragment() {

    private val viewModel = GameListViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        retainInstance = true
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.menu, menu)
        val menuItem = menu.findItem(R.id.app_bar_search)

        if (menuItem != null) {
            val searchView = menuItem.actionView as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    newText?.let { text ->
                        rvFragmentHomeGames.adapter?.let { adapter ->
                            (adapter as GamesAdapter).filterGames(text)
                        }
                    }
                    return true
                }
            })
        }

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvFragmentHomeGames.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        ////////////////////////////// Para revisar
        var games = ArrayList<Game>()

        CoroutineScope(EmptyCoroutineContext).launch {
            games = viewModel.getGames() as ArrayList<Game>
        }

        rvFragmentHomeGames.adapter = GamesAdapter(games) { game ->

            Navigation.findNavController(view)
                .navigate(
                    R.id.navGraphAction_fragmentHome_to_gameData,
                    Bundle().also { bundle ->
                        bundle.putSerializable(Game::class.java.name, game)
                    })
        }

        ////////////////////////////////
        /*
        CoroutineScope(EmptyCoroutineContext).launch {
            recyclerView.adapter = GamesAdapter(viewModel.getGames()) { game ->

                Navigation.findNavController(view)
                    .navigate(
                        R.id.navGraphAction_fragmentHome_to_gameData,
                        Bundle().also { bundle ->
                            bundle.putSerializable(Game::class.java.name, game)
                        })
            }
        }

         */


    }
}
