package com.ritu.nambath.model

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable


//Model will have two properties email and password

class User(private var email:String, private var pass:String):BaseObservable() {


    val isDataValid:Boolean
    get() =
        (getemail().contentEquals("ritunambath@gmail.com")
                || getPassword().contentEquals("123456"))

    fun getemail():String
    {
return email
    }
    fun getPassword():String
    {
        return email
    }

    fun setEmail(email: String)
    {
        this.email=email
    }
    fun setPassword(pass: String)
    {
        this.pass=pass
    }


}