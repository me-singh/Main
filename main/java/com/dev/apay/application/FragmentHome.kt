package com.dev.apay.application

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.dev.apay.R
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by user on 2/19/2018.
 */
class FragmentHome: android.support.v4.app.Fragment() {

    companion object {
        val sliderArray= arrayOf(R.drawable.account_menu,R.drawable.help_icon,R.drawable.log_out_icon,
        R.drawable.merchants_icon,R.drawable.settings_icon,R.drawable.share_icon,R.drawable.ic_action_name,
        R.drawable.tutorials_icon)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view= inflater!!.inflate(R.layout.fragment_home,container,false)

        //viewpager for image slides on home screen-->(OFFERS)
        val recyclerView=view.findViewById<RecyclerView>(R.id.offers_recyclerView)
        val addMoney=view.findViewById<Button>(R.id.add_money)
        val pay=view.findViewById<Button>(R.id.pay)
        val mobileRecharge=view.findViewById<Button>(R.id.mobile_recharge)
        val flightBooking=view.findViewById<Button>(R.id.flight_booking)

        recyclerView.layoutManager=LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter=OffersAdapter()

        addMoney.setOnClickListener {
            //add Money
        }

        pay.setOnClickListener {
            //pay money
        }

        mobileRecharge.setOnClickListener {
            //mobile recharge
        }

        flightBooking.setOnClickListener {
            //flight booking
        }
        return view
    }

    class OffersAdapter: RecyclerView.Adapter<OffersAdapter.OffersViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): OffersViewHolder {
            val view=LayoutInflater.from(parent?.context).inflate(R.layout.single_offer,parent,false)
            return OffersViewHolder(view)
        }

        override fun getItemCount(): Int {
            return FragmentHome.sliderArray.size
        }

        override fun onBindViewHolder(holder: OffersViewHolder?, position: Int) {
            holder!!.imageView.setImageResource(FragmentHome.sliderArray[position])
        }

        class OffersViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            val imageView: ImageView =itemView.findViewById<ImageView>(R.id.single_offer)
        }
    }
}