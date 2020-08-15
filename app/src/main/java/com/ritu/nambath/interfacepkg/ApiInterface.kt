package com.ritu.nambath.interfacepkg

import com.ritu.nambath.model.ApiData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    @GET("photos")
    fun getDatas() : Call<List<ApiData>>

    companion object {

        var BASE_URL = "https://jsonplaceholder.typicode.com/"

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
        }
}