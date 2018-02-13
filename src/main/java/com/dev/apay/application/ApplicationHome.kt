package com.dev.apay.application

import android.app.FragmentManager
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.dev.apay.R
import com.dev.apay.SplashFragments
import kotlinx.android.synthetic.main.activity_application_home.*
import kotlinx.android.synthetic.main.app_bar_application_home.*
import kotlinx.android.synthetic.main.content_application_home.*

class ApplicationHome : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application_home)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        offers_viewPager.adapter=OffersViewpagerAdapter(supportFragmentManager)
        offersTabLayout.setupWithViewPager(offers_viewPager)

        add_money.setOnClickListener {
            //add Money
        }

        pay.setOnClickListener {
            //pay money
        }

        mobile_recharge.setOnClickListener {
            //mobile recharge
        }

        flight_booking.setOnClickListener {
            //flight booking
        }

        nav_view.setNavigationItemSelectedListener(this)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.emergency_loan_menu->
                        Toast.makeText(baseContext,"EMERGENCY",Toast.LENGTH_SHORT).show()
                R.id.account_menu->
                        Toast.makeText(baseContext,"ACCOUNT",Toast.LENGTH_SHORT).show()
                R.id.recharge_point_menu->
                        Toast.makeText(baseContext,"RECHARGE POINT",Toast.LENGTH_SHORT).show()
            }
            return@setOnNavigationItemSelectedListener true
        }

        bottom_navigation.setOnNavigationItemReselectedListener {
            Toast.makeText(baseContext,"RESELECTED",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.application_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.merchants -> {
                // Handle the camera action
            }
            R.id.settings -> {

            }
            R.id.help_and_support -> {

            }
            R.id.share_app -> {

            }
            R.id.tutorials -> {

            }
            R.id.logout -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    class OffersViewpagerAdapter(fm:android.support.v4.app.FragmentManager):FragmentPagerAdapter(fm){

        override fun getItem(position: Int): Fragment {
            return OffersFragment.newInstance(position)
        }

        override fun getCount(): Int {
            return 8
        }

    }

}
