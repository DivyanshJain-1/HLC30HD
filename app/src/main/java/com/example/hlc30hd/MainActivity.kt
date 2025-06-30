package com.example.hlc30hd

import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val evidenceFragment = EvidenceFragment()
        val locationFragment = LocationFragment()
        val settingsFragment = SettingsFragment()

        val flfragment = findViewById<FrameLayout>(R.id.flfragment)

        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        setCurrentFragment(evidenceFragment)
        bottomNavView.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.evidence -> setCurrentFragment(evidenceFragment)
                R.id.location -> setCurrentFragment(locationFragment)
                R.id.settings -> setCurrentFragment(settingsFragment)
            }
            true
        }





    }


    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flfragment, fragment)
            commit()
        }

    }
}