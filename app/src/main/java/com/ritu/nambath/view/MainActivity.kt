package com.ritu.nambath.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.ritu.nambath.R
import com.ritu.nambath.databinding.ActivityMainBinding
import com.ritu.nambath.interfacepkg.LoginResultCallback
import com.ritu.nambath.viewmodel.LoginViewModel
import com.ritu.nambath.viewmodel.LoginViewModelfactory


public class MainActivity : AppCompatActivity() , LoginResultCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityBinding=DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        activityBinding.viewModel= ViewModelProviders.of(this,LoginViewModelfactory(this))
            .get(LoginViewModel::class.java)
    }


    private fun hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

    override fun onSuccess(message: String) {
        Toast.makeText(this,"Logged In Successfully",Toast.LENGTH_LONG).show()
        val intent= Intent(this,HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onError(message: String) {
        Toast.makeText(this,"Enter Correct Details",Toast.LENGTH_LONG).show()
    }


}