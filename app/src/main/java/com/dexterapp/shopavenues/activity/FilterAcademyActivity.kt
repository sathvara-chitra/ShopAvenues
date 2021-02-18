package com.dexterapp.shopavenues.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dexterapp.shopavenues.R
import com.dexterapp.shopavenues.adapter.FilterAdapter
import com.dexterapp.shopavenues.model.FilterModel

class FilterAcademyActivity : AppCompatActivity() {
    private var arrFilterCategory: ArrayList<FilterModel>? = ArrayList()
    private var Brandmodel: FilterModel? = null
    private var btnBack: TextView? = null
    private var rv_category: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_academy)
        AddData()
        init()
        OnClick()
    }
    private fun OnClick() {
        btnBack!!.setOnClickListener {
            finish()
        }

    }

    private fun AddData() {

        Brandmodel = FilterModel()
        var Brandmodel2 = FilterModel()
        var Brandmodel3 = FilterModel()
        var Brandmodel4 = FilterModel()
        var Brandmodel5 = FilterModel()
        Brandmodel!!.setname("Football")
        arrFilterCategory!!.add(
            Brandmodel!!
        )
        Brandmodel2!!.setname("Basketball")
        arrFilterCategory!!.add(
            Brandmodel2!!
        )
        Brandmodel3!!.setname("Golf")
        arrFilterCategory!!.add(
            Brandmodel3!!
        )
        Brandmodel4!!.setname("Badminton")
        arrFilterCategory!!.add(
            Brandmodel4!!
        )


    }

    private fun init() {
        rv_category = findViewById(R.id.rv_category)
        btnBack = findViewById(R.id.btnBack) as TextView
        btnBack!!.setText("FILTER")
        var adapter = FilterAdapter(this!!, arrFilterCategory!!)
        rv_category!!.adapter = adapter

    }

}