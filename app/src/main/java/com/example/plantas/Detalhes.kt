package com.example.plantas

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.plantas.MainActivity.Companion.EXTRA_PLANT
import com.example.plantas.databinding.DescricaoBinding
import com.example.plantas.model.Planta

class Detalhes:AppCompatActivity() {
    private lateinit var binding: DescricaoBinding
    private lateinit var planta: Planta
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bundle = intent.extras
        planta = bundle?.getSerializable(EXTRA_PLANT) as Planta
        binding = DescricaoBinding.inflate(layoutInflater)
        binding.tvNome.text = planta.nome
        binding.tvNomelatim.text = planta.nomeLatim
        binding.descricaoTv.text = planta.descricao


        setContentView(binding.root)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_partilhar -> {

                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, planta.toString())
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
                return true
            }
        }
        return true
    }
}

