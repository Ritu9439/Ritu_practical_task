package com.ritu.nambath.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ritu.nambath.R
import com.ritu.nambath.adapter.RecyclerAdapter
import com.ritu.nambath.interfacepkg.ApiInterface
import com.ritu.nambath.model.ApiData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
       var recyclerView :RecyclerView= findViewById(R.id.postdata)
        var recyclerAdapter = RecyclerAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        val apiInterface = ApiInterface.create().getDatas()
        apiInterface.enqueue( object : Callback<List<ApiData>> {
            override fun onResponse(call: Call<List<ApiData>>?, response: Response<List<ApiData>>?) {
                if(response?.body() != null)
                    recyclerAdapter.setListItems(response.body()!!)
Toast.makeText(this@HomeActivity,"sdsd",Toast.LENGTH_LONG).show()
                Log.d("asda",""+ response?.body()!!.get(0))
            }
            override fun onFailure(call: Call<List<ApiData>>?, t: Throwable?) {
                Toast.makeText(this@HomeActivity,"fail"+t.toString(),Toast.LENGTH_LONG).show()


            }
        })
    }
}