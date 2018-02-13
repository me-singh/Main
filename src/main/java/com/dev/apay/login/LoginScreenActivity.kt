package com.dev.apay.login

import android.content.Intent
import android.opengl.ETC1.isValid
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.dev.apay.R
import com.dev.apay.R.id.*
import com.dev.apay.login.Presenter.LoginPresenterImpl
import com.dev.apay.login.View.LoginView
import com.dev.apay.register.RegisterScreenActivity
import kotlinx.android.synthetic.main.content_login_screen.*
import kotlinx.android.synthetic.main.content_login_screen.view.*

class LoginScreenActivity : AppCompatActivity(),LoginView {

    companion object {
        const val REQUEST_CODE=123
        const val WITH_OTP="Sent OTP:"
        const val WITH_PASSWORD="Password:"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        fabLogIn.setOnClickListener {
            val phone= enterPhoneNumber.text.toString()
            val passOrOTP=enterPassOrOTP.text.toString()
            if (!isValid(phone,passOrOTP)){
                Snackbar.make(it,"Please Enter Required Details",Toast.LENGTH_SHORT).show()
            }
            else{
                //process credentials and give access and go to home screen
                val loginPresenter=LoginPresenterImpl(this)
                loginPresenter.validateCredentials(phone,passOrOTP)
            }
        }

        withOTPOrPass.setOnClickListener {
            withPassOrOTP()
        }

        forgetPassword.setOnClickListener {
            forgotPassword()
        }

        logInFacebook.setOnClickListener{
            facebookLogin()
        }

        signUp.setOnClickListener{
            val intent= Intent(baseContext, RegisterScreenActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }

    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        if (requestCode== REQUEST_CODE){
//            if (resultCode== Activity.RESULT_OK){
//                //changes
//            }
//        }
//    }

    override fun isValid(phone: String, password: String): Boolean {
        var valid=true

        if (phone.isEmpty()){
//            phoneNumber.error="Required Field"
            enterPhoneNumber.requestFocus()
            valid=false
        }

        val flag= (0 until password.length).any { password[it].isDigit() }
        if (password.length<5 || !flag){
            valid=false;
            enterPassOrOTP.error="Must be of size 5 or more containing minimum 1 digit"
        }

        return valid
    }

    override fun withPassOrOTP() {
        if (passOptInputLayout.hint==WITH_PASSWORD){
            passOptInputLayout.hint=WITH_OTP
            withOTPOrPass.text="Login with Password?"
        }
        else{
            passOptInputLayout.hint=WITH_PASSWORD
//            enterPassOrOTP.text=""
            withOTPOrPass.text="Login with OTP?"
        }
        //input type change
    }

    override fun forgotPassword() {
        Snackbar.make(currentFocus,"Regain password from OPT", Toast.LENGTH_SHORT).show()
    }

    override fun facebookLogin() {
        //log in with facebook credentials
    }

}
