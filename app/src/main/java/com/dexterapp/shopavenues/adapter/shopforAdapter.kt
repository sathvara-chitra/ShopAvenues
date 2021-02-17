package com.dexterapp.shopavenues.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.dexterapp.shopavenues.R
import com.dexterapp.shopavenues.activity.ProductDetailsActivity

class shopforAdapter(var imagelist: IntArray, var context: Context) :
    RecyclerView.Adapter<shopforAdapter.shopforHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): shopforHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shop_for_item, parent, false)
        return shopforHolder(view)
    }

    override fun onBindViewHolder(holder: shopforHolder, position: Int) {
        holder.image.setImageResource(imagelist[position])
        holder.itemView.setOnClickListener {
            val mainIntent = Intent(context, ProductDetailsActivity::class.java)
            context.startActivity(mainIntent)
        }

    }

    override fun getItemCount(): Int {
        return imagelist.size
    }

    inner class shopforHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image: ImageView = itemView.findViewById(R.id.image)


    }
}