package com.dev.apay.login.Model

import com.dev.apay.login.OnAuthenticationListener

/**
 * Created by user on 2/7/2018.
 */
class LoginInteracterImpl:LoginInteracter {

    override fun authenticate(phone: String, password: String, onAuthenticationListener: OnAuthenticationListener) {
        if (phone=="9999999999" && password=="hello0"){
            onAuthenticationListener.onSuccess()
        }
        else{
            onAuthenticationListener.onFailure()
        }
    }

}