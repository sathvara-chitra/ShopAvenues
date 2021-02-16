package com.dexterapp.shopavenues.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dexterapp.shopavenues.R
import com.dexterapp.shopavenues.model.CartModel

class CartAdapter(
    private val mContext: Context,
    private val list: ArrayList<CartModel>,
) :
    RecyclerView.Adapter<CartAdapter.AddressViewHolder>() {
    var removedPosition: Int? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return AddressViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        val pendingDonation: CartModel = list[position]
        holder.bind(pendingDonation)
    }

    override fun getItemCount(): Int = list.size
    open inner class AddressViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.cart_item, parent, false)) {
        private var name: TextView? = null
        private var btnMinus: ImageView? = null
        private var btnPlus: ImageView? = null
        private var edtPrice: EditText? = null

        init {
            name = itemView.findViewById(R.id.tv_name_cart)
            btnMinus = itemView.findViewById(R.id.btnMinus)
            btnPlus = itemView.findViewById(R.id.btnPlus)
            btnPlus = itemView.findViewById(R.id.btnPlus)
            edtPrice = itemView.findViewById(R.id.edtPrice)
        }

        @SuppressLint("SetTextI18n")
        fun bind(bill: CartModel) {
            var counter = 0
            name!!.setText(bill.getname())
            if (counter == 0){
                btnMinus!!.isClickable = false
            }
            btnMinus!!.setOnClickListener {
                var quantity = edtPrice!!.text.toString().toInt()
                quantity--
                if(quantity<0){
                    quantity=0;
                }

                    edtPrice!!.setText(quantity.toString())



            }
            btnPlus!!.setOnClickListener {
                var counter = edtPrice!!.text.toString().toInt()
                 counter++
                edtPrice!!.setText(counter.toString())
            }

//            address_name!!.setText(bill.getname())
//            address_number!!.setText(bill.getnumber())
//            txtAddressDesc!!.setText(bill.getdesc())
//
//            btnEditAddress!!.setOnClickListener {
//                listner.onAddressClick()
//            }
        }
    }


}