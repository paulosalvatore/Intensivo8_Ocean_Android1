package com.example.intensivo8_ocean_android1.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.intensivo8_ocean_android1.R
import com.example.intensivo8_ocean_android1.api.LugaresService
import com.example.intensivo8_ocean_android1.model.Lugar
import kotlinx.android.synthetic.main.activity_list.*
import org.jetbrains.anko.longToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListActivity : AppCompatActivity() {

    private val baseUrl = "http://192.168.15.10:3000/"

    val callback: Callback<List<Lugar>> = object : Callback<List<Lugar>> {
        override fun onFailure(call: Call<List<Lugar>>, t: Throwable) {
            Log.e("LIST_ACTIVITY", "Erro ao carregar lista de lugares: '${t.message}'.", t)

            longToast("Erro ao carregar a lista de lugares.")
        }

        override fun onResponse(call: Call<List<Lugar>>, response: Response<List<Lugar>>) {
            val listaLugares = response.body()

            listaLugares?.let {
                carregarItens(listaLugares)
                longToast("Lista de lugares carregada com sucesso.")
            } ?: longToast("Erro ao obter lista de lugares.")
        }
    }

    private fun carregarItens(listaLugares: List<Lugar>) {
        val adapter = LugarAdapter(listaLugares)

        recyclerView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(LugaresService::class.java)

        val call = service.listarLugares()
        call.enqueue(callback)
    }
}
