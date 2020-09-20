package com.example.piratehegemony.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.piratehegemony.R
import com.example.piratehegemony.data.api.PirateService
import com.example.piratehegemony.data.model.PirateResponse
import com.example.piratehegemony.ui.fragment.GetPirateFragment
import com.example.piratehegemony.ui.fragment.LoginFragment
import com.example.piratehegemony.ui.fragment.PiratesFragment
import com.example.piratehegemony.utils.NetworkManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ncapdevi.fragnav.FragNavController
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), FragNavController.RootFragmentListener {
    private var fragNavController: FragNavController =
        FragNavController(supportFragmentManager, R.id.fragment_container_view)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragNavController(savedInstanceState)
        initBottomNavigationView()
    }

    private fun initFragNavController(savedInstanceState: Bundle?) {
        val fragments = listOf<Fragment>(
            GetPirateFragment.newInstance(),
            PiratesFragment.newInstance(),
            LoginFragment.newInstance(),
        )
        fragNavController.rootFragments = fragments
        fragNavController.initialize(FragNavController.TAB1, savedInstanceState)
    }

    private fun initBottomNavigationView() {
        bottom_navigation.setOnNavigationItemSelectedListener(bottomNavigationViewListener)
    }

    private val bottomNavigationViewListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.get_pirate_page -> {
                    fragNavController.switchTab(INDEX_GET_PIRATE)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.my_pirates_page -> {
                    fragNavController.switchTab(INDEX_PIRATES)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.login_page -> {
                    fragNavController.switchTab(INDEX_LOGIN)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }


    override val numberOfRootFragments: Int
        get() = 3

    override fun getRootFragment(index: Int): Fragment {
        when (index) {
            INDEX_GET_PIRATE -> return GetPirateFragment.newInstance()
            INDEX_PIRATES -> return PiratesFragment.newInstance()
            INDEX_LOGIN -> return LoginFragment.newInstance()
        }
        throw IllegalStateException("Need to send an index that we know")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        fragNavController.onSaveInstanceState(outState)
    }

    companion object {
        val TAG: String = MainActivity.javaClass.simpleName
        const val INDEX_GET_PIRATE = FragNavController.TAB1
        private const val INDEX_PIRATES = FragNavController.TAB2
        private const val INDEX_LOGIN = FragNavController.TAB3
    }
}
