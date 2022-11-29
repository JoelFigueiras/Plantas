package com.example.plantas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.plantas.databinding.RowPlantasBinding
import com.example.plantas.model.Planta


class Adapter(val context: Context, val plantas: ArrayList<Planta>) : BaseAdapter()  {
    private lateinit var detalhesListener : DetailsListener

    override fun getCount(): Int {
        return plantas.size
    }

    override fun getItem(p0: Int): Any {
        return plantas[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val binding = RowPlantasBinding.inflate(LayoutInflater.from(context),p2,false)

        binding.nomeTv.text = plantas[p0].nome
        binding.nomeLatinoTv.text = plantas[p0].nomeLatim

        this.detalhesListener = context as DetailsListener
        binding.root.setOnClickListener {
            detalhesListener.goToDetails(plantas[p0])
        }
        return binding.root
    }
    interface DetailsListener {

        fun goToDetails(planta: Planta)
    }
}