package com.dexterapp.shopavenues.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dexterapp.shopavenues.R
import com.dexterapp.shopavenues.adapter.AddressAdapter
import com.dexterapp.shopavenues.adapter.FilterAdapter
import com.dexterapp.shopavenues.model.AddressModel
import com.dexterapp.shopavenues.model.FilterModel

class FilterActivity : AppCompatActivity() {
    private var addressmodel: FilterModel? = null
    private var Brandmodel: FilterModel? = null
    private var sizesModel: FilterModel? = null
    private var arrFilterCategory: ArrayList<FilterModel>? = ArrayList()
    private var arrFilterBrand: ArrayList<FilterModel>? = ArrayList()
    private var arrFilterSize: ArrayList<FilterModel>? = ArrayList()
    private var btnBack: TextView? = null
    private var rv_category: RecyclerView? = null
    private var rv_brand: RecyclerView? = null
    private var rv_size: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)
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
        addressmodel = FilterModel()
        var addressmodel2 = FilterModel()
        var addressmodel3 = FilterModel()
        var addressmodel4 = FilterModel()
        Brandmodel = FilterModel()
        var Brandmodel2 = FilterModel()
        var Brandmodel3 = FilterModel()
        var Brandmodel4 = FilterModel()
        var Brandmodel5 = FilterModel()
        sizesModel = FilterModel()
        var sizesModel2 = FilterModel()
        var sizesModel3 = FilterModel()
        var sizesModel4 = FilterModel()
        var sizesModel5 = FilterModel()
        addressmodel!!.setname("Clothes")
        arrFilterCategory!!.add(
            addressmodel!!
        )
        addressmodel2!!.setname("Footwear")
        arrFilterCategory!!.add(
            addressmodel2!!
        )
        addressmodel3!!.setname("Equipment")
        arrFilterCategory!!.add(
            addressmodel3!!
        )
        addressmodel4!!.setname("Accessories")
        arrFilterCategory!!.add(
            addressmodel4!!
        )

        Brandmodel!!.setname("Adidas")
        arrFilterBrand!!.add(
            Brandmodel!!
        )
        Brandmodel2!!.setname("Nike")

        arrFilterBrand!!.add(
            Brandmodel2!!
        )
        Brandmodel3!!.setname("Callaway")
        arrFilterBrand!!.add(
            Brandmodel3!!
        )
        Brandmodel4!!.setname("Wilson")

        arrFilterBrand!!.add(
            Brandmodel4!!
        )
        Brandmodel5!!.setname("Puma")
        arrFilterBrand!!.add(
            Brandmodel5!!
        )

        sizesModel!!.setname("41 EU")
        arrFilterSize!!.add(
            sizesModel!!
        )
        sizesModel2!!.setname("42 EU")
        arrFilterSize!!.add(
            sizesModel2!!
        )
        sizesModel3!!.setname("43 EU")
        arrFilterSize!!.add(
            sizesModel3!!
        )
        sizesModel4!!.setname("44.5 EU")
        arrFilterSize!!.add(
            sizesModel4!!
        )
        sizesModel5!!.setname("45 EU")

        arrFilterSize!!.add(
            sizesModel5!!
        )

    }

    private fun init() {
        rv_category = findViewById(R.id.rv_category)
        rv_brand = findViewById(R.id.rv_brand)
        rv_size = findViewById(R.id.rv_size)
        btnBack = findViewById(R.id.btnBack) as TextView
        btnBack!!.setText("FILTER")
        var adapter = FilterAdapter(this!!, arrFilterCategory!!)
        rv_category!!.adapter = adapter
        var adapter1 = FilterAdapter(this!!, arrFilterBrand!!)
        rv_brand!!.adapter = adapter1
        var adapter2 = FilterAdapter(this!!, arrFilterSize!!)
        rv_size!!.adapter = adapter2
    }


}