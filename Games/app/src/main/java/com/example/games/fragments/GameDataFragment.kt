package com.example.games.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.games.Game
import com.example.games.R
import kotlinx.android.synthetic.main.fragment_game_data.*
import kotlinx.android.synthetic.main.item.view.*

/*
Fragmento que se llama desde cada item de la lista recyclerview del fragmentoInicio.
Aqui se cargan datos detallados del juego.
 */
class GameDataFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_data, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Bundle().also { bundle ->
            val game: Game = bundle.getSerializable(Game::class.java.name) as Game

            tvGameDataFragmentTitle.text = game.title
            if (game.summary.isNullOrEmpty()) {
                tvGameDataFragmentSummary.text = getString(R.string.sin_descripcion)
            } else {
                tvGameDataFragmentSummary.text = game.summary
            }
            tvGameDataFragmentURL.text = game.url
            tvGameDataFragmentChecksum.text = game.checksum

            game.cover?.let { cover ->
                Glide.with(view).load(cover).into(ivGameDataFragmentCover)
            } ?: Glide.with(view).load(R.drawable.no_cover).into(ivGameDataFragmentCover)


        }

    }


}