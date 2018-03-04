package com.dev.apay.application

import android.content.Context
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.view.menu.MenuView
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.dev.apay.R

import kotlinx.android.synthetic.main.activity_merchants.*
import kotlinx.android.synthetic.main.content_merchants.*

class Merchants : AppCompatActivity() {

    companion object {
        //merchants images for showing their details on click
        val sliderArray= arrayOf(R.drawable.account_menu,R.drawable.help_icon,R.drawable.log_out_icon,
        R.drawable.merchants_icon,R.drawable.settings_icon,R.drawable.share_icon,R.drawable.ic_action_name,
        R.drawable.tutorials_icon)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_merchants)
        setSupportActionBar(toolbar)

        //to show upNavigation button on actionBar(back button)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        //setting merchants images in cardView in grids,which whan clicked opens activity that tells about the merchant selected
        merchantsRecyclerView.layoutManager=GridLayoutManager(this,2)
//        merchantsRecyclerView.layoutManager=LinearLayoutManager(this)
        merchantsRecyclerView.adapter=MerchantsAdapter()

    }

    //when option is selected from the actionBar of the app
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            android.R.id.home ->{
                NavUtils.navigateUpFromSameTask(this)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    //adapter for showing merchants images in a recyclerView
    class MerchantsAdapter : RecyclerView.Adapter<MerchantsAdapter.MerchantsViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MerchantsViewHolder {
            val view=LayoutInflater.from(parent!!.context).inflate(R.layout.single_merchant,parent,false)
            return MerchantsViewHolder(view)
        }

        override fun getItemCount(): Int {
            return Merchants.sliderArray.size
        }

        override fun onBindViewHolder(holder: MerchantsViewHolder?, position: Int) {
            holder!!.imageView.setImageResource(sliderArray[position])
        }

        class MerchantsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            val imageView: ImageView =itemView.findViewById(R.id.single_merchant)
        }
    }

}
