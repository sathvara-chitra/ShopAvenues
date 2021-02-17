package com.dexterapp.shopavenues.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.dexterapp.shopavenues.R
import com.dexterapp.shopavenues.model.ProductModel

class ProductAdapter(
    private val mContext: Context,
    private val list: ArrayList<ProductModel>,
) :

    RecyclerView.Adapter<ProductAdapter.AddressViewHolder>() {
    var removedPosition: Int? = null
    private var lastCheckedPosition = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return AddressViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        val pendingDonation: ProductModel = list[position]


        holder.bind(pendingDonation)
    }

    override fun getItemCount(): Int = list.size
    open inner class AddressViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.row_product_image, parent, false)) {
        private var image: ImageView? = null
        var ll_size: LinearLayout? = null

        //
        init {
            image = itemView.findViewById(R.id.image)
            ll_size = itemView.findViewById(R.id.ll_size)
//            address_number = itemView.findViewById(R.id.address_number)
//            txtAddressDesc = itemView.findViewById(R.id.txtAddressDesc)
//            btnEditAddress = itemView.findViewById(R.id.btnEditAddress)
        }

        @SuppressLint("SetTextI18n")
        fun bind(bill: ProductModel) {
            removedPosition = position
            image!!.setImageResource(R.drawable.b1)
            itemView!!.setOnClickListener {
                if (position == lastCheckedPosition) {
                    ll_size!!.setBackgroundResource(0)
                    lastCheckedPosition = -1;
                } else {
                    ll_size!!.setBackgroundResource(R.drawable.border_rectangle)
                    lastCheckedPosition = position;
                    notifyDataSetChanged();
                }



            }

        }
    }


}