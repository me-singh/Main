package com.dev.apay.login.Model

import com.dev.apay.login.OnAuthenticationListener

/**
 * Created by user on 2/7/2018.
 */
interface LoginInteracter {
    fun authenticate(phone:String,password:String,onAuthenticationListener: OnAuthenticationListener)
}