package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment=HomeFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_view,fragment).addToBackStack("HomeFragment").commit()


    }

    override fun onBackPressed() {
        if(supportFragmentManager.findFragmentById(R.id.fragment_view) is HomeFragment)
        {
            finish()
        }
        else
        {
            super.onBackPressed()
        }
    }

    }


