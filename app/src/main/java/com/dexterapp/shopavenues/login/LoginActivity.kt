package com.dexterapp.shopavenues.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dexterapp.shopavenues.HomeActivity
import com.dexterapp.shopavenues.R
import com.dexterapp.shopavenues.login.ViewModel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    lateinit var et_email: EditText
    lateinit var et_password: EditText
    private var btnSignIn: TextView? = null
    private var btnSignUp: TextView? = null
    private var txtSignIn: TextView? = null
    private var txtSignUp: TextView? = null
    private var ll_signIn: LinearLayout? = null
    private var ll_signUp: LinearLayout? = null
    private var model: LoginViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
        onClick()
    }


    private fun init() {
        et_email = findViewById(R.id.et_email)
        et_password = findViewById(R.id.et_password)
        btnSignIn = findViewById(R.id.btnSignIn)
        btnSignUp = findViewById(R.id.btnSignUp)
        txtSignIn = findViewById(R.id.txtSignIn)
        txtSignUp = findViewById(R.id.txtSignUp)
        ll_signIn = findViewById(R.id.ll_signIn)
        ll_signUp = findViewById(R.id.ll_signUp)
        model = ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    private fun onClick() {
        btnSignIn!!.setOnClickListener {
            ll_signIn!!.visibility = View.VISIBLE
            ll_signUp!!.visibility = View.GONE
//            btnSignIn!!.setBackgroundColor(resources.getColor(R.color.black))
//            btnSignUp!!.setBackgroundColor(resources.getColor(R.color.white))
//            txtSignIn!!.setTextColor(resources.getColor(R.color.white))
//            txtSignUp!!.setTextColor(resources.getColor(R.color.black))
        }
        btnSignUp!!.setOnClickListener {
            ll_signIn!!.visibility = View.GONE
            ll_signUp!!.visibility = View.VISIBLE
//            btnSignIn!!.setBackgroundColor(resources.getColor(R.color.white))
//            btnSignUp!!.setBackgroundColor(resources.getColor(R.color.black))
//            txtSignIn!!.setTextColor(resources.getColor(R.color.black))
//            txtSignUp!!.setTextColor(resources.getColor(R.color.white))
        }
        txtSignIn!!.setOnClickListener {

            if (et_email.text.isNullOrEmpty() or et_password.text.isNullOrEmpty()) {
                Toast.makeText(this, "Email and password not be empty", Toast.LENGTH_SHORT).show()
            } else
                model?.onLoginCLick(et_email.text.toString(), et_password.text.toString())
                    ?.observe(this, {
                        val mainIntent = Intent(this, HomeActivity::class.java)
                        startActivity(mainIntent)
                    })

        }
        txtSignUp!!.setOnClickListener {
            val mainIntent = Intent(this, HomeActivity::class.java)
            startActivity(mainIntent)
        }

    }
}