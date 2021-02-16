package com.dexterapp.shopavenues.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dexterapp.shopavenues.R
import com.dexterapp.shopavenues.model.Transaction_CategoryModel
import com.dexterapp.shopavenues.model.Transaction_SubCategory

class TransactionSubCategoryAdapter(
    private val mContext: Context,
    private val list: ArrayList<Transaction_SubCategory>,
) :

    RecyclerView.Adapter<TransactionSubCategoryAdapter.AddressViewHolder>() {
    var removedPosition: Int? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return AddressViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        val pendingDonation: Transaction_SubCategory = list[position]
        holder.bind(pendingDonation)
    }

    override fun getItemCount(): Int = list.size
    open inner class AddressViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.row_child_transaction, parent, false)) {
        private var name: TextView? = null
        private var txtAddressDesc: TextView? = null
        private var btnEditAddress: LinearLayout? = null

        //
        init {
            name = itemView.findViewById(R.id.name)
//            address_number = itemView.findViewById(R.id.address_number)
//            txtAddressDesc = itemView.findViewById(R.id.txtAddressDesc)
//            btnEditAddress = itemView.findViewById(R.id.btnEditAddress)
        }

        @SuppressLint("SetTextI18n")
        fun bind(bill: Transaction_SubCategory) {
            name!!.setText(bill.getname())


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