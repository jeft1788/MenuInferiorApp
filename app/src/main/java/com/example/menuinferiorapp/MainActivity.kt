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
     lateinit var botonNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        botonNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        val menu: Menu

        //val bottomNavigation: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        setupBottomNavigationView()
        replaceFragment(FragmentHome())
        botonNav.setOnItemSelectedListener {
            when(it.itemId){


                R.id.profile -> {
                    removeBadge(it.itemId)
                    replaceFragment(FragmentProfile())
                }
                R.id.settings -> replaceFragment(FragmentSettings())

                else ->{
                    replaceFragment(FragmentHome())
                }
            }
            true

        }

    }

    private fun setupBottomNavigationView() {
        botonNav.getOrCreateBadge(R.id.profile)
        botonNav.getBadge(R.id.profile)?.apply {
            number = 10
        }
    }

    private fun removeBadge(badgeId: Int) {
        botonNav.getBadge(badgeId)?.let { badgeDrawable ->
            if (badgeDrawable.isVisible) {
               botonNav.removeBadge(badgeId)
            }
        }
    }
    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()


    }
}