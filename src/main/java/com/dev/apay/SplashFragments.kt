package com.dev.apay

import android.content.Intent
import android.os.Bundle
import android.provider.Contacts.SettingsColumns.KEY
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.dev.apay.login.LoginScreenActivity
//import com.dev.apay.R.id.langSelected
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner
import kotlinx.android.synthetic.main.splash1.*

/**
 * Created by user on 1/31/2018.
 */
class SplashFragments:Fragment(),AdapterView.OnItemSelectedListener{

    private var langDropDown: MaterialBetterSpinner? = null

    companion object {
        private const val KEY="KEY"
        fun newInstance(position: Int): SplashFragments {
            val args = Bundle()
            args.putInt(KEY, position)
            val fragment = SplashFragments()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val position= arguments!!.getInt(KEY)
        when(position){
            0 -> {
                val view=inflater.inflate(R.layout.splash1,container,false)

                langDropDown = view.findViewById<MaterialBetterSpinner>(R.id.langDropDown)

                val spinnerAdapter=ArrayAdapter.createFromResource(context,R.array.language_options,R.layout.spinner_item)
                spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                langDropDown!!.setAdapter(spinnerAdapter)
                langDropDown!!.onItemSelectedListener=this

                return view
            }

            1 -> return inflater.inflate(R.layout.splash2,container,false)
            2 -> return inflater.inflate(R.layout.splash3,container,false)
            3 -> return inflater.inflate(R.layout.splash4,container,false)
            4 ->{
                    val intent= Intent(context, LoginScreenActivity::class.java)
                    startActivity(intent)
            }
        }
        return inflater.inflate(R.layout.splash1,container,false)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(context,"$position Selected",Toast.LENGTH_SHORT).show()
    }

}