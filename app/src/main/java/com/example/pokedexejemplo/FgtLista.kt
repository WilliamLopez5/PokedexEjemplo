package com.example.pokedexejemplo

import android.content.Context
import android.os.Bundle
import android.os.Debug
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexejemplo.model.IPokemonSeleccionadoListener
import com.example.pokedexejemplo.model.Pokemon
import com.example.pokedexejemplo.model.PokemonAdapter

class FgtLista : Fragment() {
    private lateinit var pokemonSelectListener: IPokemonSeleccionadoListener
    override fun onAttach(context: Context) {
        super.onAttach(context)
        pokemonSelectListener = try {
            context as IPokemonSeleccionadoListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement PokemonSelectListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fgt_lista, container, false)

        val recycler = view.findViewById<RecyclerView>(R.id.fgt_lista_recycler_view)
        recycler.layoutManager = LinearLayoutManager(requireActivity())
        val adapter = PokemonAdapter()
        recycler.adapter = adapter

        adapter.onItemClickListener = {
            pokemonSelectListener.onPokemonSeleccionado(it)
        }

        val pokemonList = mutableListOf(
            Pokemon(1, "Bulbasaur", 45, 49,
                49, 45, Pokemon.PokemonType.GRASS, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fcdn.bulbagarden.net%2Fupload%2Fthumb%2F1%2F19%2FAsh_Bulbasaur.png%2F1200px-Ash_Bulbasaur.png&f=1&nofb=1", 1
            ),
            Pokemon(
                2, "Ivysaur", 60, 62,
                63, 60,  Pokemon.PokemonType.GRASS, "https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fimg4.wikia.nocookie.net%2F__cb20140612023052%2Fpokemon%2Fimages%2F9%2F90%2FJimmy_Ivysaur.png&f=1&nofb=1", 2
            ),
            Pokemon(
                3, "Venuasaur", 80, 82,
                83, 80, Pokemon.PokemonType.GRASS, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fvignette3.wikia.nocookie.net%2Fpokemon%2Fimages%2F5%2F5e%2FBattle_Park_Venusaur.png%2Frevision%2Flatest%3Fcb%3D20151217063847&f=1&nofb=1", 3
            ),
            Pokemon(
                4, "Charmander", 39, 52,
                43, 65, Pokemon.PokemonType.FIRE, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.ytimg.com%2Fvi%2FdP_AHHZxzAw%2Fmaxresdefault.jpg&f=1&nofb=1", 4
            ),
            Pokemon(
                5, "Charmeleon", 58, 64,
                58, 80, Pokemon.PokemonType.FIRE, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fvignette.wikia.nocookie.net%2Fpoohadventures%2Fimages%2F0%2F06%2F800px-Ash_Charmeleon.png%2Frevision%2Flatest%3Fcb%3D20130815214805&f=1&nofb=1", 5
            ),
            Pokemon(
                6, "Charizzard", 78, 84,
                78, 100, Pokemon.PokemonType.FIRE, "https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fvignette4.wikia.nocookie.net%2Fpokemon%2Fimages%2Fa%2Fa9%2FAlain%27s_Charizard.png%2Frevision%2Flatest%3Fcb%3D20140404050229&f=1&nofb=1", 6
            ),
            Pokemon(
                7, "Squirtle", 44, 48,
                65, 43, Pokemon.PokemonType.WATER, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwallpapercave.com%2Fwp%2FG8CE8Gu.jpg&f=1&nofb=1", 7
            ),
            Pokemon(
                8, "Wartortle", 59, 63,
                80, 58, Pokemon.PokemonType.WATER, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fcdn.bulbagarden.net%2Fupload%2F9%2F9a%2FMay_Wartortle.png&f=1&nofb=1", 8
            ),
            Pokemon(
                9, "Blastoise", 79, 83,
                100, 78, Pokemon.PokemonType.WATER, "https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fvignette3.wikia.nocookie.net%2Fpokemon%2Fimages%2F0%2F00%2FBlue_Blastoise_PO.png%2Frevision%2Flatest%3Fcb%3D20151010081320&f=1&nofb=1", 9
            ),
            Pokemon(
                25, "Pikachu", 35, 55,
                40, 90, Pokemon.PokemonType.ELECTRIC, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.ytimg.com%2Fvi%2FZx2CBt72Ji8%2Fmaxresdefault.jpg&f=1&nofb=1", 10
            ),
            Pokemon(
                26, "Raichu", 60, 90,
                55, 110, Pokemon.PokemonType.ELECTRIC, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.ytimg.com%2Fvi%2FQS7NmgY2tM8%2Fmaxresdefault.jpg&f=1&nofb=1", 11
            )
        )

        adapter.submitList(pokemonList)

        return view
    }
}