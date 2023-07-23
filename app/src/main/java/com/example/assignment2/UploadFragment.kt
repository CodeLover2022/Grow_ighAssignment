package com.example.assignment2

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.assignment2.databinding.FragmentUploadBinding


class UploadFragment : Fragment() {

private var binding:FragmentUploadBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      binding=FragmentUploadBinding.inflate(layoutInflater,container,false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      val contract=registerForActivityResult(ActivityResultContracts.GetContent()){
   binding!!.imageView3.setImageURI(it)
        }
        binding!!.selectImgBtn.setOnClickListener {
            contract.launch("image/*")
        }
        binding!!.arrBack.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment_view,HomeFragment()).commit()
        }
    }


}