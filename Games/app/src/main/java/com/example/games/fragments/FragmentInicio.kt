package com.example.games.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.games.*
import kotlinx.android.synthetic.main.fragment_inicio.*
import com.example.games.interfaces.JuegoAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class FragmentInicio : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

          }

    private fun callServiceGetGames(){
        val userService: JuegoAPI = ServiceBuilder.getServiceBuilder().create(JuegoAPI::class.java)
        val result: Call<List<JuegosItem>> = userService.getGames()

        result.enqueue(object : Callback<List<JuegosItem>> {
            override fun onResponse(
                call: Call<List<JuegosItem>>,
                response: Response<List<JuegosItem>>
            ) {
                var cover1: CoverItem? = CoverItem("https://images.igdb.com/igdb/image/upload/t_thumb/myewkwhbaxeg5fugaaj9.jpg")
                cover1 = callServiceGetCovers(39903)



                Toast.makeText(activity,"EXITO", Toast.LENGTH_LONG).show()
                recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                recyclerView.adapter = GamesAdapter(response.body()!!, listOf(cover1,cover1))

            }

            override fun onFailure(call: Call<List<JuegosItem>>, t: Throwable) {
                Toast.makeText(activity,"ERROR", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun callServiceGetCovers(id: Int): CoverItem? {
        val userService: JuegoAPI = ServiceBuilder.getServiceBuilder().create(JuegoAPI::class.java)
        val result: Call<CoverItem> = userService.getURLCover(id)


        return result.execute().body()
    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Toast.makeText(activity,"onCreateView",Toast.LENGTH_LONG).show()
        return inflater.inflate(R.layout.fragment_inicio, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        callServiceGetGames()

    }



}
