package com.dexterapp.shopavenues.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dexterapp.shopavenues.R
import com.dexterapp.shopavenues.model.FilterModel
import com.dexterapp.shopavenues.model.Transaction_CategoryModel
import com.dexterapp.shopavenues.model.Transaction_SubCategory

class FilterAdapter(
    private val mContext: Context,
    private val list: ArrayList<FilterModel>,
) :

    RecyclerView.Adapter<FilterAdapter.AddressViewHolder>() {
    var removedPosition: Int? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return AddressViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        val pendingDonation: FilterModel = list[position]
        holder.bind(pendingDonation)
    }

    override fun getItemCount(): Int = list.size
    open inner class AddressViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.row_filter, parent, false)) {
        private var checkbox_filter: CheckBox? = null

        //
        init {
            checkbox_filter = itemView.findViewById(R.id.checkbox_filter)
//            address_number = itemView.findViewById(R.id.address_number)
//            txtAddressDesc = itemView.findViewById(R.id.txtAddressDesc)
//            btnEditAddress = itemView.findViewById(R.id.btnEditAddress)
        }

        @SuppressLint("SetTextI18n")
        fun bind(bill: FilterModel) {
            checkbox_filter!!.setText(bill.getname())


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