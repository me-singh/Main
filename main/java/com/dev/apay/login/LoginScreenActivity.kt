package com.dev.apay.login

import android.content.Context
import android.content.Intent
import android.opengl.ETC1.isValid
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.view.View
import android.widget.Toast
import com.dev.apay.R
import com.dev.apay.R.id.*
import com.dev.apay.SplashActivity
import com.dev.apay.login.Presenter.LoginPresenterImpl
import com.dev.apay.login.View.LoginView
import com.dev.apay.register.RegisterScreenActivity
import kotlinx.android.synthetic.main.content_login_screen.*
import kotlinx.android.synthetic.main.content_login_screen.view.*
import android.content.Context.INPUT_METHOD_SERVICE
import android.support.constraint.ConstraintLayout
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.LinearLayout

//login activity for login into the account for the app
class LoginScreenActivity : AppCompatActivity(),LoginView {

    companion object {
        const val REQUEST_CODE=123
        const val WITH_OTP="Sent OTP:"
        const val WITH_PASSWORD="Password:"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        //to make keyboard dissappear on first openning of the activity even if the edittext is the first element focused
//        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //to make keyboard dissapear when clicked on the specific button
//// Get your layout set up, this is just an example
//        mainLayout = findViewById(R.id.myLinearLayout) as LinearLayout
//
//        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.hideSoftInputFromWindow(mainLayout.windowToken, 0)

        val mainLayout=findViewById<ConstraintLayout>(R.id.login_constraint_layout)

        fabLogIn.setOnClickListener {

            val imm=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(mainLayout.windowToken,0)

            val phone= enterPhoneNumber.text.toString()
            val passOrOTP=enterPassOrOTP.text.toString()
            if (!isValid(phone,passOrOTP)){
                Snackbar.make(it,"Please Enter Required Details",Toast.LENGTH_SHORT).show()
            }
            else{
                progressBar.visibility=View.VISIBLE
                Handler().postDelayed(Runnable {
                    val loginPresenter=LoginPresenterImpl(this)
                    loginPresenter.validateCredentials(phone,passOrOTP)//sending details to check for valid credentials
                    progressBar.visibility=View.INVISIBLE
                },1500)
                //if details are valid as per requirements to the programmer
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

    //**finish the app execution on back pressed on this activity
    override fun onBackPressed() {
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(a)
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        if (requestCode== REQUEST_CODE){
//            if (resultCode== Activity.RESULT_OK){
//                //changes
//            }
//        }
//    }

    //checking for validation of phone and password syntactically
    override fun isValid(phone: String, password: String): Boolean {
        var valid=true

        if (phone.isEmpty()){
//            phoneNumber.error="Required Field"
            enterPhoneNumber.requestFocus()
            valid=false
        }

        val flag= (0 until password.length).any { password[it].isDigit() }
        if (password.length<5 || !flag){
            valid=false
            enterPassOrOTP.error="Must be of size 5 or more containing minimum 1 digit"
            enterPassOrOTP.setText("")
        }

        return valid
    }

    override fun withPassOrOTP() {
        if (passOptInputLayout.hint==WITH_PASSWORD){
            passOptInputLayout.hint=WITH_OTP
            withOTPOrPass.text="Login with Password?"
            enterPassOrOTP.setText("")
            enterPassOrOTP.inputType=InputType.TYPE_CLASS_NUMBER
        }
        else{
            passOptInputLayout.hint=WITH_PASSWORD
            withOTPOrPass.text="Login with OTP?"
            enterPassOrOTP.setText("")
            enterPassOrOTP.inputType=InputType.TYPE_TEXT_VARIATION_PASSWORD
        }
        enterPassOrOTP.requestFocus()
        //input type change
    }

    override fun forgotPassword() {
        Snackbar.make(currentFocus,"Regain password from OPT", Toast.LENGTH_SHORT).show()
    }

    override fun facebookLogin() {
        //log in with facebook credentials
    }

}
