package com.dev.apay.application

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.dev.apay.R

import kotlinx.android.synthetic.main.activity_merchants.*
import kotlinx.android.synthetic.main.content_merchants.*

class Merchants : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_merchants)
        setSupportActionBar(toolbar)

        merchantsRecyclerView.adapter=
    }

}
