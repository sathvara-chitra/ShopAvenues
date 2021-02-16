package com.dexterapp.shopavenues.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.dexterapp.shopavenues.R

class AvenuesAdapter(var imagelist: IntArray, var context: Context) :
    RecyclerView.Adapter<AvenuesAdapter.AvenuesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvenuesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.avenues_item, parent, false)
        return AvenuesViewHolder(view)
    }

    override fun onBindViewHolder(holder: AvenuesViewHolder, position: Int) {
        holder.image.setImageResource(imagelist[position])

    }

    override fun getItemCount(): Int {
        return imagelist.size
    }

    inner class AvenuesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image: ImageView = itemView.findViewById(R.id.avenues_image)

    }


}