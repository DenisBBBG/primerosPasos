package com.example.games.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.games.*
import kotlinx.android.synthetic.main.fragment_inicio.*
import com.example.games.interfaces.JuegoAPI
import kotlinx.android.synthetic.main.fragment_inicio.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val titulo = ""

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentInicio.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentInicio : Fragment() {
    // TODO: Rename and change types of parameters
    private var titulo: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            titulo = it.getString(titulo)
        }


          }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false)

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentInicio.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentInicio().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val request = ServiceBuilder.buildService(JuegoAPI::class.java)
        val call = request.getGames(getString(R.string.api_key))

        call.enqueue(object : Callback<Juego> {
            override fun onResponse(call: Call<Juego>, response: Response<Juego>) {
                if (response.isSuccessful) {

                    recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                    recyclerView.adapter = GamesAdapter(response.body()!!.results)
                }


            }

            override fun onFailure(call: Call<Juego>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })


    }


}
