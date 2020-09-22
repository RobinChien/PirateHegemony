package com.example.piratehegemony.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.piratehegemony.R
import com.example.piratehegemony.data.enum.PirateImage
import com.example.piratehegemony.ui.viewmodel.GetPirateViewModel
import kotlinx.android.synthetic.main.card_view_pirate.view.*
import kotlinx.android.synthetic.main.fragment_get_pirate.*
import kotlin.random.Random

class GetPirateFragment : Fragment() {
    private val TAG: String = tag.toString()
    private val getPirateViewModel: GetPirateViewModel by lazy {
        ViewModelProvider(this).get(GetPirateViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_get_pirate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setGetPirateViewModel()
        button.setOnClickListener {
            setGetPirateViewModel()
        }
    }

    private fun setGetPirateViewModel() {
        getPirateViewModel.pirateInfoLiveData((1 .. 10).random()).observe(viewLifecycleOwner, Observer { pirate ->
            val pirateCard = pirate_card
            pirateCard.image.setImageDrawable(context?.let { ContextCompat.getDrawable(it, PirateImage.getPirateImage(pirate.id).pirateImage) })
            pirateCard.pirate_name.text = pirate.name
            pirateCard.pirate_height.text = pirate.getHeightString()
            pirateCard.pirate_weight.text = pirate.getWeightString()
            pirateCard.pirate_attack.text = pirate.getAttackString()
        })
    }

    companion object {
        fun newInstance(): GetPirateFragment = GetPirateFragment()
    }
}
