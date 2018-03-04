package com.dev.apay.application

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev.apay.R

/**
 * Created by user on 2/19/2018.
 */
class FragmentRechargePoint:android.support.v4.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_recharge_point,container,false)
    }

}