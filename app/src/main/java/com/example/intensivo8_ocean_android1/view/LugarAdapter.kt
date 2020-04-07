package com.example.intensivo8_ocean_android1.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.intensivo8_ocean_android1.R
import com.example.intensivo8_ocean_android1.model.Lugar
import kotlinx.android.synthetic.main.lugar_item.view.*
import org.jetbrains.anko.longToast
import java.text.NumberFormat
import java.util.*


class LugarAdapter(private val items: List<Lugar>) :
    RecyclerView.Adapter<LugarAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lugar_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = items.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bindView(item)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Lugar) = with(itemView) {
            Glide.with(this).load(item.imagemUrl).into(ivLugar)
            tvNome.text = item.nome
            tvEndereco.text = item.endereco
            tvHorario.text = "${item.horarioInicio}h ~ ${item.horarioFim}h"

            val format = NumberFormat.getCurrencyInstance()
            format.maximumFractionDigits = 2
            format.currency = Currency.getInstance("BRL")
            val valorDisponivel = format.format(item.valorDisponivel)

            tvValorDisponivel.text = valorDisponivel
            tvPessoa.text = item.pessoa

            setOnClickListener {
                with(context) {
                    longToast("${item.nome} foi clicado.")
                }
            }
        }
    }
}