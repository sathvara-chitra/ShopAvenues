package com.dexterapp.shopavenues.activity

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.RecyclerView
import com.dexterapp.shopavenues.R
import com.dexterapp.shopavenues.adapter.FilterAdapter
import com.dexterapp.shopavenues.adapter.ProductAdapter
import com.dexterapp.shopavenues.adapter.SizeAdapter
import com.dexterapp.shopavenues.model.FilterModel
import com.dexterapp.shopavenues.model.ProductModel
import com.dexterapp.shopavenues.model.SizeModel
import com.google.android.material.bottomsheet.BottomSheetBehavior


class ProductDetailsActivity : AppCompatActivity() {
    var btnBack: TextView? = null
    var bottom_sheet: CoordinatorLayout? = null
    var rv_productSize: RecyclerView? = null
    var rv_productColors: RecyclerView? = null
    private var sizesModel: SizeModel? = null
    private var productModel: ProductModel? = null
    private var arrFilterSize: ArrayList<SizeModel>? = ArrayList()
    private var arrProductImage: ArrayList<ProductModel>? = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        AppData()
        init()
    }

    private fun AppData() {
        sizesModel = SizeModel()
        productModel = ProductModel()

        var sizesModel2 = SizeModel()
        var sizesModel3 = SizeModel()
        var sizesModel4 = SizeModel()
        var sizesModel5 = SizeModel()
        sizesModel!!.setname("41 EU")
        sizesModel!!.settype("select")
        arrFilterSize!!.add(
            sizesModel!!
        )
        sizesModel2!!.setname("42 EU")
        sizesModel2!!.settype("deselect")
        arrFilterSize!!.add(
            sizesModel2!!
        )
        sizesModel3!!.setname("43 EU")
        sizesModel3!!.settype("deselect")
        arrFilterSize!!.add(
            sizesModel3!!
        )
        sizesModel4!!.setname("44.5 EU")
        sizesModel4!!.settype("select")
        arrFilterSize!!.add(
            sizesModel4!!
        )
        sizesModel5!!.setname("45 EU")
        sizesModel5!!.settype("select")

        arrFilterSize!!.add(
            sizesModel5!!
        )

        productModel!!.setname(R.drawable.b1)
        arrProductImage!!.add(
            productModel!!
        )
        var productModel2 = ProductModel()
        productModel2!!.setname(R.drawable.b1)
        arrProductImage!!.add(productModel2)
        var productModel3 = ProductModel()
        productModel3!!.setname(R.drawable.b1)
        arrProductImage!!.add(productModel3)
        var productModel4 = ProductModel()
        productModel4!!.setname(R.drawable.b1)
        arrProductImage!!.add(productModel4)
        var productModel5 = ProductModel()
        productModel5!!.setname(R.drawable.b1)
        arrProductImage!!.add(productModel5)
    }

    private fun init() {
        val images = intArrayOf(
            R.drawable.maledemo,
            R.drawable.femaledemo,
            R.drawable.maledemo,
        )
        btnBack = findViewById(R.id.btnBack)
        bottom_sheet = findViewById(R.id.bottom_sheet)
        rv_productSize = findViewById(R.id.rv_productSize)
        rv_productColors = findViewById(R.id.rv_productColors)
        var adapter2 = SizeAdapter(this!!, arrFilterSize!!)
        rv_productSize!!.adapter = adapter2
        var adapter = ProductAdapter(this!!, arrProductImage!!)
        rv_productColors!!.adapter = adapter

        onClick()
    }

    private fun onClick() {
        btnBack!!.setOnClickListener {
            finish()
        }
    }
}