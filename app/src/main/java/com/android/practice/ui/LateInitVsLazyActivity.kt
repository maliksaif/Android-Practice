package com.android.practice.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.practice.R
import com.android.practice.models.User

class LateInitVsLazyActivity : AppCompatActivity() {

    private lateinit var userLateInit : User
    private val userLazy : User by lazy{ User ("1","Ted")}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_late_init_lazy)
        systemBars()

        if(::userLateInit.isInitialized){
            Log.d(TAG, "onCreate: $userLateInit")
        }

    }


    private fun systemBars(){

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }

}