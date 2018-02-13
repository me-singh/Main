package com.dev.apay.register

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.dev.apay.R
import kotlinx.android.synthetic.main.activity_register_screen.*
import kotlinx.android.synthetic.main.content_register_screen.*

class RegisterScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_screen)
        setSupportActionBar(toolbar)

        signUpConfirmFab.setOnClickListener {
            if (!isValid()){
                Snackbar.make(it,"Please Enter Required Details Correctly",Toast.LENGTH_SHORT).show()
            }
            else{
                //enter details to the database
                finish()
            }
        }

        faceBookSignUp.setOnClickListener {
            //sign up with facebook credentials
        }
    }

    private fun isValid():Boolean{

        var valid=true

        val name=enterName.text.toString()
        val email=enterEmail.text.toString()
        val phoneNo=enterPhone.text.toString()
        val password=enterPassword.text.toString()
        val rePassword=verifyPassword.text.toString()

        if (name.isEmpty()){
            enterName.error="Required Field"
            valid=false
        }

        if (phoneNo.isEmpty()){
            enterPhone.error="Required Field"
            valid=false
        }

        val flag= (0 until password.length).any { password[it].isDigit() }
        if (password.length<5 || !flag){
            enterPassword.error="Must be minimum 5 characters containing minimum 1 digit"
            valid=false
        }

        if (!email.isEmpty() && !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            enterEmail.error="Enter a valid Email"
            valid=false
        }

        if (password!=rePassword){
            enterPassword.error="Password do not match!"
            enterPassword.requestFocus()
            valid=false
        }

        return valid
    }

}
