package com.example.games

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.games.fragments.FragmentInicio
import com.example.games.interfaces.JuegoAPI
import kotlinx.android.synthetic.main.fragment_inicio.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val request = ServiceBuilder.buildService(JuegoAPI::class.java)
        val call = request.getGames("*")

        call.enqueue(object : Callback<Juego> {
            override fun onResponse(call: Call<Juego>, response: Response<Juego>) {
                if (response.isSuccessful) {
                    recyclerView.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = FragmentInicio.GamesAdapter(response.body()!!.results)
                    }
                }
            }

            override fun onFailure(call: Call<Juego>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        }





}