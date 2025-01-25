package com.example.pokedexejemplo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val id: Long, val strName: String, val intHp: Int,
    val intAttack: Int, val intDefense: Int, val intSpeed: Int,
    val type: PokemonType, val strURL: String, val intSound: Int
) : Parcelable {
    enum class PokemonType {
        GRASS, FIRE, WATER, FIGHTER, ELECTRIC
    }
}