package com.example.a4symbolmath

import FaveFragment
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.a4symbolmath.fragments.GenerateFragment
import com.example.a4symbolmath.fragments.HomeFragment
import com.example.a4symbolmath.fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.parse.ParseObject
import com.parse.ParseUser

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: FragmentManager = supportFragmentManager
        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemSelectedListener{
                item ->
            var fragmentToShow: Fragment? =null
            when (item.itemId){
                R.id.action_home -> {
                    fragmentToShow=HomeFragment()
                }
                R.id.action_generate -> {
                    fragmentToShow= GenerateFragment()
                }
                R.id.action_fave -> {
                    fragmentToShow= FaveFragment()
                }
                R.id.action_settings -> {
                    fragmentToShow= SettingsFragment()
                }
                R.id.action_logout -> {
                    ParseUser.logOut()
                    val currentUser = ParseUser.getCurrentUser()
                    gotoLoginActivity()
                }
            }
            if(fragmentToShow != null){
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragmentToShow).commit()
            }
            true
        }

        // Set default selection
        findViewById<BottomNavigationView>(R.id.bottom_navigation).selectedItemId = R.id.action_home

        //code provided by back4app to test the apps connectivity to the parse sdk and the test was successful (used before adding bottom navigation view and fragments)
/*                val firstObject = ParseObject("FirstClass")
                firstObject.put("message","Hey ! First message from android. Parse is now connected")
                firstObject.saveInBackground {
                    if (it != null){
                        it.localizedMessage?.let { message -> Log.e("MainActivity", message) }
                    }else{
                        Log.d("MainActivity","Object saved.")
                    }
                }*/

    }
    private fun gotoLoginActivity() {
        val intent = Intent(this@MainActivity, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}


