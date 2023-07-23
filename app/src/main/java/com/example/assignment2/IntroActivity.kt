package com.example.assignment2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.example.assignment2.IntroFragment.FirstIntroFragment
import com.example.assignment2.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityIntroBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)
        val firstStart = sharedPreferences.getString("FirstTimeInstall","")
        Log.d("hello",firstStart.toString())
        binding.btnSkip.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        if (firstStart.equals("Yes")) {


            startActivity(Intent(this,MainActivity::class.java))
            finish()

        }
        else
        {
            val sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("FirstTimeInstall", "Yes")
            editor.apply()
            initializingFragment()

        }
    }
    private fun initializingFragment() {
        val fragment = FirstIntroFragment()


        supportFragmentManager.beginTransaction().replace(R.id.Intro_fragment_view, fragment)
            .commit()
    }
}
