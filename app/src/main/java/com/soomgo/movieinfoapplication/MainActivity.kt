package com.soomgo.movieinfoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.soomgo.movieinfoapplication.databinding.ActivityMainBinding
import com.soomgo.movieinfoapplication.presentaion.movie.MovieFragment
import com.soomgo.movieinfoapplication.presentaion.my.MyFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        initView()
        initNavigationBarListener()
    }

    private fun initView(){
        changeFragment(MovieFragment())
    }

    private fun initNavigationBarListener(){
        binding.bottomNavigationView.setOnItemSelectedListener {
            val fragment = when(it.itemId){
                R.id.movieTab -> MovieFragment()
                R.id.scrapTab -> MyFragment()
                else -> throw IllegalArgumentException("not found menu item id")
            }

            changeFragment(fragment)
            true
        }
    }

    private fun changeFragment(fragment : Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, fragment, null)
            .addToBackStack(null)
            .commit()
    }
}