package com.hyunjung.moviesearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hyunjung.moviesearch.databinding.ActivityMainBinding
import com.hyunjung.moviesearch.ui.view.RecentFragment
import com.hyunjung.moviesearch.ui.view.SearchFragment

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupBottomNavigationView()

        if (savedInstanceState == null) {
            binding.navMain.selectedItemId = R.id.fragment_search
        }
    }

    private fun setupBottomNavigationView() {
        binding.navMain.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.fragment_search -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_main, SearchFragment())
                        .commit()
                    true
                }

                R.id.fragment_recent -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_main, RecentFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }


}