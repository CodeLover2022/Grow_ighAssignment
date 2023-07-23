package com.example.assignment2.Retrofit

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val base_url="https://pixabay.com/api/"
interface ApiService {

    @GET("?key=38391524-81f15d5e317050cc11d815581&q")
   fun getImage(@Query ("q") q:String,@Query ("page") Page:Int, @Query("per_page") per_page:Int): Call<Responses>

    companion object{

        var instance:Retrofit?=null

        fun createRetro(context:Context):Retrofit {
            val okHttpClient=OkHttpClient.Builder().build()
            if (instance != null) return instance!!
            else return Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build()
        }
    }
}