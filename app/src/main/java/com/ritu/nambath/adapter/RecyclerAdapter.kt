package com.ritu.nambath.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ritu.nambath.R
import com.ritu.nambath.model.ApiData

class RecyclerAdapter(val context: Context) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    var myList : List<ApiData> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.rowdata,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.tvName.text = myList.get(position).title

        Log.d("sdad",""+myList.get(position).thumbnailUrl)
        Glide.with(context).load(myList.get(position).thumbnailUrl).dontAnimate()
            .placeholder(R.drawable.user)
            .into(holder.image)
    }

    fun setListItems(myList: List<ApiData>){
        this.myList = myList;
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val tvName: TextView = itemView!!.findViewById(R.id.title)
        val image: ImageView = itemView!!.findViewById(R.id.image)

    }
}