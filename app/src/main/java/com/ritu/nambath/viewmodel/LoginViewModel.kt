package com.ritu.nambath.viewmodel

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.ViewModel
import com.ritu.nambath.interfacepkg.LoginResultCallback
import com.ritu.nambath.model.User

class LoginViewModel(private val listener:LoginResultCallback):ViewModel() {
    private val user: User
    init {
        this.user=User("","")
    }
    val emailTextWatcher:TextWatcher
        get() = object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                user?.  setEmail(p0.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        }


    val passTextWatcher:TextWatcher
        get() = object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                user?.  setPassword(p0.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        }

    fun onLoginClicked(v:View)
    {
        if (user.isDataValid)
            listener.onSuccess("Login Sucess")
        else
            listener.onError("Login error")

    }
}