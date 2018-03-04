package com.dev.apay.login.Presenter

import android.content.Context
import android.content.Intent
import android.support.design.widget.Snackbar
import android.widget.Toast
import com.dev.apay.application.ApplicationHome
import com.dev.apay.login.Model.LoginInteracterImpl
import com.dev.apay.login.OnAuthenticationListener
import java.security.AccessControlContext

/**
 * Created by user on 2/7/2018.
 */

//presenter for connecting view with model of login activity
class LoginPresenterImpl(var context: Context?) :LoginPresenter,OnAuthenticationListener{

    //call to model for authenticating user by checking credentials
    override fun validateCredentials(phone: String, password: String) {
        val loginInteracterImpl=LoginInteracterImpl()
        loginInteracterImpl.authenticate(phone,password,this)
    }

    //on successfully login
    override fun onSuccess() {
        //Intent to home screen
        Toast.makeText(context,"To Home Screen:)", Toast.LENGTH_SHORT).show()
        val intent=Intent(context,ApplicationHome::class.java)
        context!!.startActivity(intent)
    }

    //on login credentials mismatch
    override fun onFailure() {
        Toast.makeText(context,"Incorrect Credentials",Toast.LENGTH_SHORT).show()
    }

}