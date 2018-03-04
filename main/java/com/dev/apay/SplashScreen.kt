package com.dev.apay

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.dev.apay.R.layout.activity_splash_screen

//shows the splash screen till the app starts
class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

//        Showing splash screen with a timer. This will be useful when you want to show case your app logo / company
        Handler().postDelayed(Runnable {
            startActivity(Intent(baseContext,SplashActivity::class.java))
            finish()
        },1500)

    }
}
