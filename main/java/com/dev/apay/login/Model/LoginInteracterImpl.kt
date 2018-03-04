package com.dev.apay.login.Model

import com.dev.apay.login.OnAuthenticationListener

/**
 * Created by user on 2/7/2018.
 */
//model class for dealing with database and data for the app
class LoginInteracterImpl:LoginInteracter {

    //check database for valid credentials
    override fun authenticate(phone: String, password: String, onAuthenticationListener: OnAuthenticationListener) {
        if (phone=="9999999999" && password=="qqqq1"){
            onAuthenticationListener.onSuccess()
        }
        else{
            onAuthenticationListener.onFailure()
        }
    }

}