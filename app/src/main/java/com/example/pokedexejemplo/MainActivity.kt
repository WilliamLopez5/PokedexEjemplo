package com.example.pokedexejemplo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import com.example.pokedexejemplo.model.IPokemonSeleccionadoListener
import com.example.pokedexejemplo.model.Pokemon

class MainActivity : AppCompatActivity(), IPokemonSeleccionadoListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onPokemonSeleccionado(pokemon: Pokemon) {
        findNavController(R.id.main_navigation_container)
            .navigate(FgtListaDirections.actionFgtListaToFgtDetalle(pokemon))
    }
}