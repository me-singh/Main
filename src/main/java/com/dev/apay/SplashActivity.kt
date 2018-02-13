package com.dev.apay

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import com.dev.apay.login.LoginScreenActivity
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.android.synthetic.main.content_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)

        val viewPagerAdapter=MyViewPagerAdapter(supportFragmentManager)
        splashViewpager.adapter=viewPagerAdapter
        splashTabLayout.setupWithViewPager(splashViewpager)

        skipButton.setOnClickListener {
            val intent=Intent(baseContext,LoginScreenActivity::class.java)
            startActivity(intent)
        }
    }

    class MyViewPagerAdapter(fm: FragmentManager) :FragmentPagerAdapter(fm){
        override fun getItem(position: Int): Fragment {
            return SplashFragments.newInstance(position)
        }
        override fun getCount(): Int {
            return 4
        }
    }

}