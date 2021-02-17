package com.dexterapp.shopavenues.activity

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.dexterapp.shopavenues.HomeActivity
import com.dexterapp.shopavenues.R
import com.dexterapp.shopavenues.adapter.TransactionSubCategoryAdapter
import com.dexterapp.shopavenues.model.Transaction_SubCategory


class CheckoutActivity : AppCompatActivity() {
    var btnBuy: LinearLayout? = null
    private var btnBack: TextView? = null
    private var rv_transactionList: RecyclerView? = null
    private var adapter: TransactionSubCategoryAdapter? = null
    private var arrTransation: ArrayList<Transaction_SubCategory>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)
        AddData()
        init()
        onClick()
    }

    private fun AddData() {
        arrTransation = ArrayList()

        var SubCategorymodel = Transaction_SubCategory()
        SubCategorymodel.setname("Nike Air Max 90")
        SubCategorymodel.setname("Nike Air Max 90")
        arrTransation!!.add(SubCategorymodel)

        arrTransation!!.add(
            SubCategorymodel
        )



    }

    private fun init() {
        btnBack = findViewById(R.id.btnBack) as TextView
        btnBuy = findViewById(R.id.btnBuy) as LinearLayout
        rv_transactionList = findViewById(R.id.rv_productlist) as RecyclerView
        btnBack!!.setText("Checkout")
        adapter = TransactionSubCategoryAdapter(this!!, arrTransation!!)

        rv_transactionList!!.adapter = adapter

    }
    private fun onClick() {
        btnBack!!.setOnClickListener {
            finish()
        }
        btnBuy!!.setOnClickListener {
            showDialog(this)
        }
    }

    fun showDialog(activity: Activity?) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_alert_dialog)
        val btnShopping = dialog.findViewById(R.id.btnShopping) as LinearLayout
        btnShopping.setOnClickListener {
            val mainIntent = Intent(activity,HomeActivity::class.java)
            startActivity(mainIntent)
            finish()
            dialog.dismiss()
        }

        dialog.show()
    }
}