package com.dexterapp.shopavenues.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dexterapp.shopavenues.R
import com.dexterapp.shopavenues.activity.CheckoutActivity
import com.dexterapp.shopavenues.adapter.AddressAdapter
import com.dexterapp.shopavenues.adapter.CartAdapter
import com.dexterapp.shopavenues.model.AddressModel
import com.dexterapp.shopavenues.model.CartModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CartFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var adapter: CartAdapter? = null
    private var arrCart: ArrayList<CartModel>? = null
    private var rvCartList: RecyclerView? = null
    private var titleName: TextView? = null
    private var btnBuy: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_cart, container, false)
        AddData()
        init(root)
        onClick()
        return root;
    }

    private fun onClick() {
        btnBuy!!.setOnClickListener {
            val mainIntent = Intent(activity,CheckoutActivity::class.java)
            startActivity(mainIntent)
        }
    }

    private fun init(root: View) {
        btnBuy = root!!.findViewById(R.id.btnBuy)
        titleName = root!!.findViewById(R.id.titleName)
        rvCartList = root!!.findViewById(R.id.rvCartList)
        adapter = CartAdapter(activity!!, arrCart!!)
        rvCartList!!.adapter = adapter
        titleName!!.setText("Cart")

    }

    private fun AddData() {
        arrCart = ArrayList()
        var cartModel1 = CartModel()
        cartModel1.setname("Nike Air Max 90")
        arrCart!!.add(
            cartModel1
        )
        var cartModel2 = CartModel()
        cartModel2.setname("Nike Air Max 90")
        arrCart!!.add(
            cartModel2
        )


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CartFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CartFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}