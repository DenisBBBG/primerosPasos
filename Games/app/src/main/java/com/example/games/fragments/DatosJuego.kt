package com.example.games.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.games.R
import kotlinx.android.synthetic.main.fragment_datos_juego.*

class DatosJuego : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_datos_juego, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentoDatosTitulo.text = requireArguments().getString("titulo")

        if(!requireArguments().getString("descripcion").isNullOrEmpty()){
            fragmentoDatosDescripcion.text = requireArguments().getString("descripcion")
        }else{
            fragmentoDatosDescripcion.text = "Sin descripción."
        }


        val url = requireArguments().getString("url")
        if(!url.equals("sinURL")){
            Glide.with(this).load("https:$url").into(fragmentoDatosCaratula)
        }else{
            Glide.with(this).load(R.mipmap.sin_imagen).into(fragmentoDatosCaratula)
        }
        fragmentoDatosUrl.text = "Página web: "+ requireArguments().getString("urlJuego")
        fragmentoDatosChecksum.text = "Checksum: "+requireArguments().getString("checksum")
    }



}