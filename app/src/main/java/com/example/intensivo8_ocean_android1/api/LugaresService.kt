package com.example.intensivo8_ocean_android1.api

import com.example.intensivo8_ocean_android1.model.Lugar
import retrofit2.Call
import retrofit2.http.GET

interface LugaresService {
    @GET("lugares")
    fun listarLugares(): Call<List<Lugar>>
}
