package com.dev.apay.login.Presenter

/**
 * Created by user on 2/7/2018.
 */
interface LoginPresenter {
    fun validateCredentials(phone:String,password:String)
}