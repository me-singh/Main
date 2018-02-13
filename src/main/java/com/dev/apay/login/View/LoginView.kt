package com.dev.apay.login.View

/**
 * Created by user on 2/7/2018.
 */

interface LoginView{

    fun isValid(phone:String,password:String):Boolean

    fun withPassOrOTP()

    fun forgotPassword()

    fun facebookLogin()

}
