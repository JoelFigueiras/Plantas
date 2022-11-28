package com.example.plantas.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.plantas.Detalhes
import com.example.plantas.MainActivity
import com.example.plantas.databinding.RowPlantasBinding
import com.example.plantas.model.Planta


class Adapter(val context: Context, val plantas: ArrayList<Planta>) : BaseAdapter() {

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
        return binding.root
    }
}