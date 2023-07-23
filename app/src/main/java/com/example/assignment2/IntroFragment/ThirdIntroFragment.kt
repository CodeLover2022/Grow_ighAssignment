package com.example.assignment2.IntroFragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.assignment2.MainActivity
import com.example.assignment2.R
import com.example.assignment2.databinding.FragmentThirdIntroBinding


class ThirdIntroFragment : Fragment() {
    private var binding:FragmentThirdIntroBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentThirdIntroBinding.inflate(layoutInflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btnReady?.setOnClickListener {
            val intent= Intent(activity,MainActivity::class.java)
            startActivity(intent)

        }
    }


}