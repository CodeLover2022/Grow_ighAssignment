package com.example.assignment2.IntroFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.assignment2.R
import com.example.assignment2.databinding.FragmentSecondIntroBinding


class SecondIntroFragment : Fragment() {
    // TODO: Rename and change types of parameters

private var binding:FragmentSecondIntroBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding= FragmentSecondIntroBinding.inflate(layoutInflater,container,false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btnNext12?.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.Intro_fragment_view,ThirdIntroFragment()).commit()
        }

    }
}