package com.example.menuinferiorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.example.menuinferiorapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var toolbar: ActionBar
     private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val menu: Menu

        //val bottomNavigation: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        replaceFragment(FragmentHome())
        binding.bottomNavigationView.setOnClickListener {
            when(it.id){

                R.id.home -> replaceFragment(FragmentHome())
                R.id.profile -> replaceFragment(FragmentProfile())
                R.id.settings -> replaceFragment(FragmentSettings())

                else ->{

                }

            }

            true

        }

    }
    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()


    }
}