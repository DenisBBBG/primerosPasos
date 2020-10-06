package com.example.games.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.games.GameModel
import com.example.games.R
import kotlinx.android.synthetic.main.fragment_game_data.*

class GameDataFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game_data, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { arg ->
            val game = arg.getSerializable(GameModel::class.java.name) as GameModel
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
    }


}