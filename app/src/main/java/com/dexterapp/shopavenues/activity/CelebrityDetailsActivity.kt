package com.dexterapp.shopavenues.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dexterapp.shopavenues.R
import com.dexterapp.shopavenues.adapter.TrandingAdapter

class CelebrityDetailsActivity : AppCompatActivity() {
    private lateinit var TrandingRv: RecyclerView
    private lateinit var btnBack: ImageView

    val imagestrending = intArrayOf(
        R.drawable.p1,
        R.drawable.p2,
        R.drawable.p3,
        R.drawable.p4

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_celebrity_details)
        init()
    }

    private fun init() {
        TrandingRv = findViewById(R.id.tranding_rv)
        btnBack = findViewById(R.id.btnBack)
        TrandingRv.layoutManager = GridLayoutManager(this, 2)
        val trandingAdapter = TrandingAdapter(imagestrending, this!!)
        TrandingRv.adapter = trandingAdapter
        btnBack.setOnClickListener {
            finish()
        }
    }
}