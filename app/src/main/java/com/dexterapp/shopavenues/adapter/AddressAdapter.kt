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
import kotlin.math.roundToInt

class AddressAdapter(
    private val mContext: Context,
    private val list: ArrayList<AddressModel>,
    val listner: onAddressClick
) :

    RecyclerView.Adapter<AddressAdapter.AddressViewHolder>() {
    var removedPosition: Int? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return AddressViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        val pendingDonation: AddressModel = list[position]
        holder.bind(pendingDonation)
    }

    override fun getItemCount(): Int = list.size
    inner class AddressViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.row_address, parent, false)) {
        private var address_name: TextView? = null
        private var address_number: TextView? = null
        private var txtAddressDesc: TextView? = null
        private var btnEditAddress: LinearLayout? = null

        //
        init {
            address_name = itemView.findViewById(R.id.address_name)
            address_number = itemView.findViewById(R.id.address_number)
            txtAddressDesc = itemView.findViewById(R.id.txtAddressDesc)
            btnEditAddress = itemView.findViewById(R.id.btnEditAddress)
        }

        @SuppressLint("SetTextI18n")
        fun bind(bill: AddressModel) {
            address_name!!.setText(bill.getname())
            address_number!!.setText(bill.getnumber())
            txtAddressDesc!!.setText(bill.getdesc())

            btnEditAddress!!.setOnClickListener {
                listner.onAddressClick()
            }
        }
    }

    interface onAddressClick {
        fun onAddressClick()
    }
}