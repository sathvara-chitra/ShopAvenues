package com.dexterapp.shopavenues

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    private var btnSignIn: TextView? = null
    private var btnSignUp: TextView? = null
    private var txtSignIn: TextView? = null
    private var txtSignUp: TextView? = null
    private var ll_signIn: LinearLayout? = null
    private var ll_signUp: LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
        onClick()
    }


    private fun init() {
        btnSignIn = findViewById(R.id.btnSignIn) as TextView
        btnSignUp = findViewById(R.id.btnSignUp) as TextView
        txtSignIn = findViewById(R.id.txtSignIn) as TextView
        txtSignUp = findViewById(R.id.txtSignUp) as TextView
        ll_signIn = findViewById(R.id.ll_signIn) as LinearLayout
        ll_signUp = findViewById(R.id.ll_signUp) as LinearLayout
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
            val mainIntent = Intent(this, HomeActivity::class.java)
            startActivity(mainIntent)
        }
        txtSignUp!!.setOnClickListener {
            val mainIntent = Intent(this, HomeActivity::class.java)
            startActivity(mainIntent)
        }

    }
}