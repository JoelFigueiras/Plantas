package com.example.plantas
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.plantas.adapter.Adapter
import com.example.plantas.databinding.ActivityMainBinding
import com.example.plantas.model.Planta
import java.io.Serializable

class MainActivity : AppCompatActivity(), Adapter.DetailsListener {
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
        setContentView(binding.root)

    }
    fun display(array: ArrayList<Planta>) {
        val listView = binding.lvPlantas
        val adapter = Adapter(this, array)
        listView.adapter = adapter
    }

    override fun goToDetails(planta: Planta){

           val intent = Intent(this@MainActivity, Detalhes::class.java)
            val bundle = Bundle()
            bundle.putSerializable(EXTRA_PLANT,planta)
            intent.putExtras(bundle)
           startActivity(intent)

       }



    companion object {
        const val EXTRA_PLANT = "extra_plant"
    }
}