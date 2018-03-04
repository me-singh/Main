package com.dev.apay.application

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.dev.apay.R
import kotlinx.android.synthetic.main.activity_application_home.*
import kotlinx.android.synthetic.main.app_bar_application_home.*
import kotlinx.android.synthetic.main.content_application_home.*
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView
import android.util.Log


//Home screen for the app containing all navigationDrawer and bottomNavigation with other functionalities
class ApplicationHome : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application_home)
        setSupportActionBar(toolbar)

        //navigationDrawer in the activity
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        BottomNavigationViewHelper.removeShiftMode(bottom_navigation)

        supportFragmentManager.beginTransaction().add(R.id.fragment_container,FragmentHome(),null).commit()

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home_menu->{
                    Toast.makeText(baseContext,"HOME",Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container,FragmentHome(),null).commit()
                }
                R.id.emergency_loan_menu->{
                    Toast.makeText(baseContext,"EMERGENCY",Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container,FragmentEmergencyLoan(),null).commit()
                }
                R.id.account_menu->{
                    Toast.makeText(baseContext,"ACCOUNT",Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container,FragmentAccount(),null).commit()
                }
                R.id.recharge_point_menu->{
                    Toast.makeText(baseContext,"RECHARGE POINT",Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container,FragmentRechargePoint(),null).commit()
                }
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
            val a = Intent(Intent.ACTION_MAIN)
            a.addCategory(Intent.CATEGORY_HOME)
            a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(a)
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
            R.id.balance-> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.merchants -> {
                val intent=Intent(this,Merchants::class.java)
                startActivity(intent)
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

    internal object BottomNavigationViewHelper {

        @SuppressLint("RestrictedApi")
        fun removeShiftMode(view: BottomNavigationView) {
            val menuView = view.getChildAt(0) as BottomNavigationMenuView
            try {
                val shiftingMode = menuView.javaClass.getDeclaredField("mShiftingMode")
                shiftingMode.isAccessible = true
                shiftingMode.setBoolean(menuView, false)
                shiftingMode.isAccessible = false
                for (i in 0 until menuView.childCount) {
                    val item = menuView.getChildAt(i) as BottomNavigationItemView
                    item.setShiftingMode(false)
                    // set once again checked value, so view will be updated
                    item.setChecked(item.itemData.isChecked)
                }
            } catch (e: NoSuchFieldException) {
                Log.e("ERROR NO SUCH FIELD", "Unable to get shift mode field")
            } catch (e: IllegalAccessException) {
                Log.e("ERROR ILLEGAL ALG", "Unable to change value of shift mode")
            }

        }
    }

}
