package com.example.plantas

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.plantas.databinding.DescricaoBinding
import com.example.plantas.model.Planta

class Detalhes:AppCompatActivity() {
    private lateinit var binding: DescricaoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DescricaoBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun display()
    {

    }
    interface DetailsListener {

        fun goToDetails()
    }
}