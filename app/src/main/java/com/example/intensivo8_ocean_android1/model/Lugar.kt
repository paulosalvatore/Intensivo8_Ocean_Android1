package com.example.intensivo8_ocean_android1.model

data class Lugar(val nome: String,
                 val endereco: String,
                 val imagemUrl: String,
                 val horarioInicio: Int,
                 val horarioFim: Int,
                 val valorDisponivel: Double,
                 val pessoa: String)
