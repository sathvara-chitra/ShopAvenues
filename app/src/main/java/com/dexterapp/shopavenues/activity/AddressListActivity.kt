package com.dexterapp.shopavenues.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dexterapp.shopavenues.R
import com.dexterapp.shopavenues.adapter.AddressAdapter
import com.dexterapp.shopavenues.model.AddressModel

class AddressListActivity : AppCompatActivity(), AddressAdapter.onAddressClick {
    private var adapter: AddressAdapter? = null
    private var arrAddress: ArrayList<AddressModel>? = null
    private var rvAddressList: RecyclerView? = null
    private var ll_addresslist: LinearLayout? = null
    private var ll_NewAddress: LinearLayout? = null
    private var txtNewAddress: TextView? = null
    private var txtNew: TextView? = null
    private var btnBack: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address_list)
        AddData()
        init()
        OnClick()

    }

    private fun OnClick() {
        btnBack!!.setOnClickListener {
            finish()
        }
        txtNewAddress!!.setOnClickListener {

            val mainIntent = Intent(this, AddAddressActivity::class.java)
            startActivity(mainIntent)
        }
        txtNew!!.setOnClickListener {
            val mainIntent = Intent(this, AddAddressActivity::class.java)
            startActivity(mainIntent)
        }
    }

    private fun AddData() {
        arrAddress = ArrayList()
        var addressmodel = AddressModel()
        addressmodel.setname("Test1")
        addressmodel.setnumber("0123456789")
        addressmodel.setdesc("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ante ipsum, sollicitudin eget faucibus a, tincidunt non lacus. Etiam odio est, suscipit nec tincidunt ut, varius sed tortor")

        arrAddress!!.add(
            addressmodel
        )


    }

    private fun init() {
        rvAddressList = findViewById(R.id.rv_addresslist)
        ll_addresslist = findViewById(R.id.ll_addresslist)
        ll_NewAddress = findViewById(R.id.ll_NewAddress)
        txtNewAddress = findViewById(R.id.txtNewAddress)
        txtNew = findViewById(R.id.txtNew)
        btnBack = findViewById(R.id.btnBack) as TextView
        btnBack!!.setText("Address")

        if (arrAddress!!.size > 0) {
            ll_addresslist!!.visibility = View.VISIBLE
            ll_NewAddress!!.visibility = View.GONE
            adapter = AddressAdapter(this!!, arrAddress!!, this)
            rvAddressList!!.adapter = adapter
        } else {
            ll_addresslist!!.visibility = View.GONE
            ll_NewAddress!!.visibility = View.VISIBLE
        }
    }

    override fun onAddressClick() {
//        val mainIntent = Intent(this, EditAddressActivity::class.java)
        val mainIntent = Intent(this, ProductDetailsActivity::class.java)
        startActivity(mainIntent)
//        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);

//        val mainIntent = Intent(this, FilterActivity::class.java)
//        startActivity(mainIntent)
//        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
    }
}