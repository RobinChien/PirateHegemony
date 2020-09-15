package com.example.piratehegemony.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.piratehegemony.R

class GetPirateFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_get_pirate, container, false)
    }

    companion object {
        fun newInstance(): GetPirateFragment = GetPirateFragment()
    }
}
