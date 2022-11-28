package com.example.plantas

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.BaseAdapter
import com.example.plantas.adapter.Adapter
import com.example.plantas.databinding.ActivityMainBinding
import com.example.plantas.model.Planta

class MainActivity : AppCompatActivity(), Detalhes.DetailsListener {
    private lateinit var binding: ActivityMainBinding
    private val plantas = ArrayList<Planta>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        plantas.add(Planta("Rosas", "Rosas do meu quintal", "cheirosas"))
        plantas.add(Planta("Rosas", "Rosas do meu quintal", "cheirosas"))
        plantas.add(Planta("Rosas", "Rosas do meu quintal", "cheirosas"))
        plantas.add(Planta("Rosas", "Rosas do meu quintal", "cheirosas"))
        display(plantas)
        goToDetails()
        setContentView(binding.root)
    }
    fun display(array: ArrayList<Planta>) {
        val listView = binding.lvPlantas
        val adapter = Adapter(this.baseContext, array)
        listView.adapter = adapter
    }

    override fun goToDetails() {
       binding.root.setOnClickListener( {
           val intent = Intent(this@MainActivity, Detalhes::class.java)
           startActivity(intent)
       })
    }
}