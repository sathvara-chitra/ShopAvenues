package com.dexterapp.shopavenues.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.dexterapp.shopavenues.R

class BrandAdapter(var imagelist: IntArray, var context: Context) :
    RecyclerView.Adapter<BrandAdapter.BrandsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.brand_item, parent, false)
        return BrandsViewHolder(view)
    }

    override fun onBindViewHolder(holder: BrandsViewHolder, position: Int) {
        holder.image.setImageResource(imagelist[position])

    }

    override fun getItemCount(): Int {
        return imagelist.size
    }

    inner class BrandsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image: ImageView = itemView.findViewById(R.id.brand_image)

    }


}