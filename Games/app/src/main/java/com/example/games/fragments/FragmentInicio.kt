package com.example.games.fragments

import android.os.Bundle
import android.os.StrictMode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.games.*
import com.example.games.interfaces.JuegoAPI
import kotlinx.android.synthetic.main.fragment_datos_juego.*
import kotlinx.android.synthetic.main.fragment_inicio.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*
Fragment que se carga al iniciar la aplicacion. En este fragment estoy
cargando dos listas, una con objetos para cada imagen y otra para cada juego.
 */
class FragmentInicio : Fragment() {


    var listaJuegos = mutableListOf<JuegosItem>()
    var listaCovers = mutableListOf<CoverItem>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

          }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_inicio, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Modifico politicas de android para poder cargar los datos
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val userService: JuegoAPI = ServiceBuilder.getServiceBuilder().create(JuegoAPI::class.java)

        //Si la lista de juegos esta vacia se realizan las consultas necesarias para crear la.
        if (listaJuegos.isEmpty()){
            val result: Call<List<JuegosItem>> = userService.getGames()
            listaJuegos = (result.execute().body() as MutableList<JuegosItem>?)!!

            //Por cada juego, se busca su caratula con el id y se añade a una lista.
            for (juego in listaJuegos){

                //Si no tiene caratula se le pone una imagen por defecto
                if (juego.cover != null){

                    val result2: Call<List<CoverItem>> = userService.getURLCover(juego.cover)
                    listaCovers.add(result2.execute().body()!![0])
                }else{
                    listaCovers.add(CoverItem("sinURL"))
                }


            }
        }



        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        recyclerView.adapter = GamesAdapter(listaJuegos, listaCovers){ JuegosItem,CoversItem  ->
            val bundle = bundleOf("titulo" to JuegosItem.name,"descripcion" to JuegosItem.summary,"url" to CoversItem.url,"urlJuego" to JuegosItem.url,"checksum" to JuegosItem.checksum)
            Navigation.findNavController(view).navigate(R.id.datosJuego, bundle)

        }
    }



}
