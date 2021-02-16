package com.dexterapp.shopavenues.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.dexterapp.shopavenues.R
import com.dexterapp.shopavenues.adapter.TransactionAdapter
import com.dexterapp.shopavenues.adapter.TransactionSubCategoryAdapter
import com.dexterapp.shopavenues.model.Transaction_CategoryModel
import com.dexterapp.shopavenues.model.Transaction_SubCategory

class TransactionDetailsActivity : AppCompatActivity() {
    private var btnBack: TextView? = null
    private var rv_transactionList: RecyclerView? = null
    private var adapter: TransactionSubCategoryAdapter? = null
    private var arrTransation: ArrayList<Transaction_SubCategory>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction_details)
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
        rv_transactionList = findViewById(R.id.rv_transactionDetailsList) as RecyclerView
        btnBack!!.setText("Detail Transaction")
        adapter = TransactionSubCategoryAdapter(this!!, arrTransation!!)

        rv_transactionList!!.adapter = adapter

    }
    private fun onClick() {
        btnBack!!.setOnClickListener {
            finish()
        }
    }
}