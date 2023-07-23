package com.example.assignment2.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignment2.R
import com.example.assignment2.Retrofit.Hit

class ImageAdapter(val context: Context, val images:ArrayList<Hit>):RecyclerView.Adapter<ImageAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
       val img=itemView.findViewById<ImageView>(R.id.imageView2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recy_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val img=images[position]
       Glide.with(context).load(img.largeImageURL).into(holder.img)
    }
}