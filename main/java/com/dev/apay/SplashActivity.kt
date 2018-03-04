package com.dev.apay

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.content.ContextCompat.startActivity
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import com.dev.apay.login.LoginScreenActivity
import kotlinx.android.synthetic.main.activity_starter.*
import kotlinx.android.synthetic.main.content_starter.*
import android.support.v4.view.ViewPager.OnPageChangeListener



//shows the starter activity for the app->(it shows the details about the app)
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //to acquire full screen functionality without xml
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_starter)

        //setting viewpager with dots feature
        val viewPagerAdapter=MyViewPagerAdapter(supportFragmentManager)
        splashViewpager.adapter=viewPagerAdapter
        splashTabLayout.setupWithViewPager(splashViewpager)

        var flag=false;
        splashViewpager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
                if (flag && state==ViewPager.SCROLL_STATE_DRAGGING){
                    val intent=Intent(baseContext,LoginScreenActivity::class.java)
                    startActivity(intent)
                }
            }
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
//                if (position==3){
//                    val intent=Intent(baseContext,LoginScreenActivity::class.java)
//                    startActivity(intent)
//                }
            }
            override fun onPageSelected(position: Int) {
                // Check if this is the page you want.
                if(position==3)
                    flag=true
            }
        })

        skipButton.setOnClickListener {
            val intent=Intent(baseContext,LoginScreenActivity::class.java)
            startActivity(intent)
        }
    }

    //viewpager adapter for starter screen
    class MyViewPagerAdapter(fm: FragmentManager) :FragmentPagerAdapter(fm){
        override fun getItem(position: Int): Fragment {
            return SplashFragments.newInstance(position)
        }
        override fun getCount(): Int {
            return 4
        }
    }

}