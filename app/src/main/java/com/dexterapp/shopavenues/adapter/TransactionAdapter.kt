package com.dexterapp.shopavenues.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dexterapp.shopavenues.R
import com.dexterapp.shopavenues.model.AddressModel
import com.dexterapp.shopavenues.model.Transaction_CategoryModel
import kotlin.math.roundToInt

class TransactionAdapter(
    private val mContext: Context,
    private val list: ArrayList<Transaction_CategoryModel>,
    val listner: onAddressClick
) :

    RecyclerView.Adapter<TransactionAdapter.AddressViewHolder>() {
    var removedPosition: Int? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return AddressViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        val pendingDonation: Transaction_CategoryModel = list[position]
        holder.bind(pendingDonation)
    }

    override fun getItemCount(): Int = list.size
    open inner class AddressViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.row_transaction, parent, false)) {
        private var btnViewDetails: LinearLayout? = null
        private var rv_child_transaction: RecyclerView? = null
        private var address_number: TextView? = null
        private var txtAddressDesc: TextView? = null
        private var btnEditAddress: LinearLayout? = null

        init {
            btnViewDetails = itemView.findViewById(R.id.btnViewDetails)
            rv_child_transaction = itemView.findViewById(R.id.rv_child_transaction)
//            address_number = itemView.findViewById(R.id.address_number)
//            txtAddressDesc = itemView.findViewById(R.id.txtAddressDesc)
//            btnEditAddress = itemView.findViewById(R.id.btnEditAddress)
        }

        @SuppressLint("SetTextI18n")
        fun bind(bill: Transaction_CategoryModel) {
           val  adapter = TransactionSubCategoryAdapter(mContext, bill.getSubCategory()!!)
            rv_child_transaction!!.adapter = adapter
            btnViewDetails!!.setOnClickListener {
                listner.onAddressClick()
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

    interface onAddressClick {
        fun onAddressClick()
    }
}