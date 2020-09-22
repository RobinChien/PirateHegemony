package com.example.piratehegemony.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.piratehegemony.R
import com.example.piratehegemony.ui.viewmodel.PiratesViewModel

class PiratesFragment : Fragment() {
    val TAG: String = tag.toString()
    val piratesViewModel: PiratesViewModel by lazy {
        ViewModelProvider(this).get(PiratesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pirates, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setPirateListViewModel()
    }

    private fun setPirateListViewModel() {
        piratesViewModel.pirateListLiveData().observe(viewLifecycleOwner, Observer { pirates ->
            Log.d(TAG, "Pirates: $pirates")
        })
    }

    companion object {
        fun newInstance(): PiratesFragment = PiratesFragment()
    }
}
