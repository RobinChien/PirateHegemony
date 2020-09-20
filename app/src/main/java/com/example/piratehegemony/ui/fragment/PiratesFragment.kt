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
import com.example.piratehegemony.ui.viewmodel.PirateListViewModel
import kotlinx.android.synthetic.main.fragment_pirates.*

class PiratesFragment : Fragment() {
    val TAG: String = tag.toString()
    val pirateListViewModel: PirateListViewModel by lazy {
        ViewModelProvider(this).get(PirateListViewModel::class.java)
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
        pirateListViewModel.pirateListLiveData().observe(viewLifecycleOwner, Observer { pirates ->
            Log.d(TAG, "Pirates: $pirates")
            if (!pirates.isNullOrEmpty()) {
                pirate_text_view.text =
                    pirates.flatMap { (name, _) -> listOf(name) }
                        .joinToString(prefix = "<", postfix = ">", separator = "•")
            }
        })
    }

    companion object {
        fun newInstance(): PiratesFragment = PiratesFragment()
    }
}
