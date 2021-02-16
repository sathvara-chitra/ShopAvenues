package com.dexterapp.shopavenues.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.dexterapp.shopavenues.R
import com.dexterapp.shopavenues.adapter.CartAdapter
import com.dexterapp.shopavenues.adapter.WishAdapter
import com.dexterapp.shopavenues.model.CartModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WishlistFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WishlistFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var adapter: WishAdapter? = null
    private var arrCart: ArrayList<CartModel>? = null
    private var rv_wishlist: RecyclerView? = null
    private var titleName: TextView? = null
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
        val root =  inflater.inflate(R.layout.fragment_wishlist, container, false)
        AddData()
        init(root)
        return root
    }
    private fun init(root: View) {
        titleName = root!!.findViewById(R.id.titleName)
        rv_wishlist = root!!.findViewById(R.id.rv_wishlist)
        adapter = WishAdapter(activity!!, arrCart!!)
        rv_wishlist!!.adapter = adapter
        titleName!!.setText("Wishlist")

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
         * @return A new instance of fragment WishlistFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WishlistFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}