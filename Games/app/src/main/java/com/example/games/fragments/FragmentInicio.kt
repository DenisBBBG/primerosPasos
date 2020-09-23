package com.example.games.fragments

import android.os.Bundle
import android.os.StrictMode
import android.view.*
import android.widget.SearchView

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.games.*
import com.example.games.interfaces.JuegoAPI
import kotlinx.android.synthetic.main.fragment_inicio.*
import retrofit2.Call
import java.util.*
import kotlin.collections.ArrayList

/*
Fragment que se carga al iniciar la aplicacion. En este fragment estoy
cargando dos listas, una con objetos para cada imagen y otra para cada juego.
 */
class FragmentInicio : Fragment() {


    var listaJuegos = ArrayList<JuegosItem>()
    var listaJuegosDisplay = ArrayList<JuegosItem>()


    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)


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
                    if (newText!!.isNotEmpty()) {
                        listaJuegosDisplay.clear()
                        val search = newText.toLowerCase(Locale.getDefault())
                        listaJuegos.forEach {
                            if (it.name.toLowerCase(Locale.getDefault()).contains(search)) {
                                listaJuegosDisplay.add(it)
                            }
                        }
                        recyclerView.adapter!!.notifyDataSetChanged()
                    } else {
                        listaJuegosDisplay.clear()
                        listaJuegosDisplay.addAll(listaJuegos)
                        recyclerView.adapter!!.notifyDataSetChanged()
                    }
                    return true
                }
            })
        }

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return super.onOptionsItemSelected(item)
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
        if (listaJuegos.isEmpty()) {
            val result: Call<List<JuegosItem>> = userService.getGames()
            listaJuegos = (result.execute().body() as ArrayList<JuegosItem>?)!!

            //Por cada juego, se busca su caratula con el id y se añade a una lista.
            for (juego in listaJuegos) {

                //Si no tiene caratula se le pone una imagen por defecto
                if (juego.cover != null) {
                    val result2: Call<List<CoverItem>> = userService.getURLCover(juego.cover)
                    juego.coverURL = result2.execute().body()!![0].url
                } else {
                    juego.coverURL = "sinURL"
                }
            }
        }
        listaJuegosDisplay.clear()
        listaJuegosDisplay.addAll(listaJuegos)



        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        recyclerView.adapter = GamesAdapter(listaJuegosDisplay) { JuegosItem ->
            val bundle = bundleOf(
                "titulo" to JuegosItem.name,
                "descripcion" to JuegosItem.summary,
                "url" to JuegosItem.coverURL,
                "urlJuego" to JuegosItem.url,
                "checksum" to JuegosItem.checksum
            )
            Navigation.findNavController(view).navigate(R.id.datosJuego, bundle)

        }
    }


}
