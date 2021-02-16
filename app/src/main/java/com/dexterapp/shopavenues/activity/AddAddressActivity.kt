package com.dexterapp.shopavenues.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.dexterapp.shopavenues.R

class AddAddressActivity : AppCompatActivity() {
    private var btnBack: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_address)
        init()
        onClick()
    }

    private fun onClick() {
        btnBack!!.setOnClickListener {
            finish()
        }
    }

    private fun init() {
        btnBack = findViewById(R.id.btnBack) as TextView
        btnBack!!.setText("Add Address")

    }
}