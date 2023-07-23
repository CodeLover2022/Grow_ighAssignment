package com.example.assignment2

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.assignment2.Adapter.ImageAdapter
import com.example.assignment2.Retrofit.ApiService
import com.example.assignment2.Retrofit.Hit
import com.example.assignment2.Retrofit.Responses
import com.example.assignment2.databinding.ActivityMainBinding.inflate
import com.example.assignment2.databinding.FragmentFeedBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.*


class FeedFragment : Fragment() {


private var binding:FragmentFeedBinding?=null
private lateinit var obj:Retrofit
private lateinit var arr:ArrayList<Hit>
var srch:String?=null
    var total_page=1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentFeedBinding.inflate(layoutInflater, container, false)
    return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arr=ArrayList()
        binding?.srchBtn?.setOnClickListener {
            srch = binding!!.etSearch.text.toString()
            if (srch!!.isEmpty()) Toast.makeText(
                requireContext(),
                "Please fill the field",
                Toast.LENGTH_SHORT
            ).show()
            else {
                obj = ApiService.createRetro(requireContext())
                val api_Service = obj.create(ApiService::class.java)
                val body = api_Service.getImage(srch!!, total_page, 10)
                binding!!.recyView.layoutManager = LinearLayoutManager(context)
                body.enqueue(object : Callback<Responses> {
                    override fun onResponse(call: Call<Responses>, response: Response<Responses>) {

                        arr = response.body()!!.hits
                        binding!!.recyView.adapter = ImageAdapter(requireContext(), arr)


                    }

                    override fun onFailure(call: Call<Responses>, t: Throwable) {
                        Toast.makeText(context, t.message.toString(), Toast.LENGTH_SHORT).show()
                    }
//

                })
            }
        }
            val swipe = binding?.swipeRef
        swipe?.setOnRefreshListener {

            swipingLayout(swipe,srch!!)


        }



    }

    private fun swipingLayout(swipe:SwipeRefreshLayout,srch:String) {
        arr.clear()
        binding!!.recyView.adapter?.notifyDataSetChanged()
        val api_Service = obj.create(ApiService::class.java)
        val body = api_Service.getImage(srch, ++total_page, 10)
        body.enqueue(object : Callback<Responses> {
            override fun onResponse(call: Call<Responses>, response: Response<Responses>) {
                arr = response.body()!!.hits
                binding!!.recyView.adapter = ImageAdapter(requireContext(), arr)


            }

            override fun onFailure(call: Call<Responses>, t: Throwable) {
                Toast.makeText(context, t.message.toString(), Toast.LENGTH_SHORT).show()
            }


        })
        swipe.isRefreshing=false
    }
}





