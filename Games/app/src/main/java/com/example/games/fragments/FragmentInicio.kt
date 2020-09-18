package com.example.games.fragments

import android.os.Bundle
import android.os.StrictMode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.games.*
import com.example.games.interfaces.JuegoAPI
import kotlinx.android.synthetic.main.fragment_inicio.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FragmentInicio : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

          }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Toast.makeText(activity, "onCreateView", Toast.LENGTH_LONG).show()
        return inflater.inflate(R.layout.fragment_inicio, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()

        StrictMode.setThreadPolicy(policy)
        val userService: JuegoAPI = ServiceBuilder.getServiceBuilder().create(JuegoAPI::class.java)
        val result: Call<List<JuegosItem>> = userService.getGames()


        val listaJuegos: List<JuegosItem> = result.execute().body()!!
        val listaCovers = mutableListOf<CoverItem>()

        for (juego in listaJuegos){

            if (juego.cover != null){

                val result2: Call<List<CoverItem>> = userService.getURLCover(juego.cover)
                listaCovers.add(result2.execute().body()!![0])
            }
            else{
                listaCovers.add(CoverItem("images.igdb.com/igdb/image/upload/t_thumb/myewkwhbaxeg5fugaaj9.jpg"))
            }


        }


        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = GamesAdapter(listaJuegos, listaCovers)
    }



}
