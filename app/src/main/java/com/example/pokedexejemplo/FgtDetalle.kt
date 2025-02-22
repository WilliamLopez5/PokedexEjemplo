package com.example.pokedexejemplo

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.pokedexejemplo.model.Pokemon

class FgtDetalle : Fragment() {
    private val args: FgtDetalleArgs by navArgs()

    private lateinit var imageView: ImageView
    private lateinit var hpText: TextView
    private lateinit var attackText: TextView
    private lateinit var defenseText: TextView
    private lateinit var speedText: TextView
    private lateinit var loadingWheel: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_fgt_detalle, container, false)

        val pokemon = args.pokemon
        imageView = rootView.findViewById(R.id.fgt_detalle_img)
        hpText = rootView.findViewById(R.id.fgt_detalle_hp)
        attackText = rootView.findViewById(R.id.fgt_detalle_ataque)
        defenseText = rootView.findViewById(R.id.fragment_detail_defense)
        speedText = rootView.findViewById(R.id.fragment_detail_speed)
        loadingWheel = rootView.findViewById(R.id.fgt_detalle_loading)

        setPokemonData(pokemon)
        return rootView
    }

    private fun setPokemonData(pokemon: Pokemon) {
        loadingWheel.visibility = View.VISIBLE
        Glide.with(this).load(pokemon.strURL).listener(object: RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>,
                isFirstResource: Boolean
            ): Boolean {
                loadingWheel.visibility = View.GONE
                return false
            }

            override fun onResourceReady(
                resource: Drawable,
                model: Any,
                target: Target<Drawable>?,
                dataSource: DataSource,
                isFirstResource: Boolean
            ): Boolean {
                loadingWheel.visibility = View.GONE
                return false
            }
        }).into(imageView)


        hpText.text = getString(R.string.hp_format, pokemon.intHp)
        attackText.text = getString(R.string.attack_format, pokemon.intAttack)
        defenseText.text = getString(R.string.defense_format, pokemon.intDefense)
        speedText.text = getString(R.string.speed_format, pokemon.intSpeed)
    }

}