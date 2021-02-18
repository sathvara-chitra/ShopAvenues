package com.dexterapp.shopavenues.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dexterapp.shopavenues.R
import com.dexterapp.shopavenues.activity.ProductDetailsActivity

class AvenuesListAdapter(
    var imagelist: IntArray,
    var arrayAvenue: ArrayList<String>,
    var context: Context,
    val listner: onAvenueListClick
) :
    RecyclerView.Adapter<AvenuesListAdapter.AvenuesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvenuesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_avenues_item, parent, false)
        return AvenuesViewHolder(view)
    }

    override fun onBindViewHolder(holder: AvenuesViewHolder, position: Int) {
        holder.image.setImageResource(imagelist[position])
        holder.txtAvenue.setText(arrayAvenue!!.get(position))

        holder.itemView.setOnClickListener {
            listner.onAvenueListClick()
        }

    }

    override fun getItemCount(): Int {
        return imagelist.size
    }

    inner class AvenuesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image: ImageView = itemView.findViewById(R.id.avenues_image)
        var txtAvenue: TextView = itemView.findViewById(R.id.txtAvenue)

    }


    interface onAvenueListClick {
        fun onAvenueListClick()
    }
}