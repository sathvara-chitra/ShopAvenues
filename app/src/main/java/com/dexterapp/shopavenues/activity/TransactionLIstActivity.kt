package com.dexterapp.shopavenues.activity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.dexterapp.shopavenues.R
import com.dexterapp.shopavenues.adapter.TransactionAdapter
import com.dexterapp.shopavenues.model.Transaction_CategoryModel
import com.dexterapp.shopavenues.model.Transaction_SubCategory


class TransactionLIstActivity : AppCompatActivity(), TransactionAdapter.onAddressClick {
    private var adapter: TransactionAdapter? = null
    private var arrTransation: ArrayList<Transaction_CategoryModel>? = null
    private var arrSubTransation: ArrayList<Transaction_SubCategory>? = null
    private var btnBack: TextView? = null
    private var rv_transactionList: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction_l_ist)
        AddData()
        init()
        onClick()
    }

    private fun AddData() {
        arrTransation = ArrayList()
        arrSubTransation = ArrayList()

        var Categorymodel = Transaction_CategoryModel()
        var SubCategorymodel = Transaction_SubCategory()
        Categorymodel.setname("Test1")
        SubCategorymodel.setname("Nike Air Max 90")
        SubCategorymodel.setname("Nike Air Max 90")
        arrSubTransation!!.add(SubCategorymodel)
        Categorymodel.setSubCategory(arrSubTransation)

        arrTransation!!.add(
            Categorymodel
        )

        Categorymodel.setname("Test1")
        SubCategorymodel.setname("Nike Air Max 90")
        arrSubTransation!!.add(SubCategorymodel)
        Categorymodel.setSubCategory(arrSubTransation)

        arrTransation!!.add(
            Categorymodel
        )

    }

    private fun onClick() {
        btnBack!!.setOnClickListener {
            finish()
        }
    }

    private fun init() {
        btnBack = findViewById(R.id.btnBack) as TextView
        rv_transactionList = findViewById(R.id.rv_transactionList) as RecyclerView
        btnBack!!.setText("Transaction")
        adapter = TransactionAdapter(this!!, arrTransation!!, this)
        val horizontalDecoration = DividerItemDecoration(
            this,
            DividerItemDecoration.VERTICAL
        )
        val horizontalDivider =
            ContextCompat.getDrawable(this, R.drawable.line_divider)
        horizontalDecoration.setDrawable(horizontalDivider!!)
        rv_transactionList!!.addItemDecoration(horizontalDecoration);

        rv_transactionList!!.adapter = adapter

    }

    override fun onAddressClick() {

        val mainIntent = Intent(this, TransactionDetailsActivity::class.java)
        startActivity(mainIntent)
    }
}