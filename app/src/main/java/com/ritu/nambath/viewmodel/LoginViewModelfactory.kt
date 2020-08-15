package com.ritu.nambath.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ritu.nambath.interfacepkg.LoginResultCallback

class LoginViewModelfactory(private val listener:LoginResultCallback):ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(listener) as T
    }

}