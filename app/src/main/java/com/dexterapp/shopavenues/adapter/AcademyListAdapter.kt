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
import com.dexterapp.shopavenues.activity.AcademyDetailsActivity

class AcademyListAdapter(
    var imagelist: IntArray,
    var context: Context

) :
    RecyclerView.Adapter<AcademyListAdapter.AvenuesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvenuesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.academy_item, parent, false)
        return AvenuesViewHolder(view)
    }

    override fun onBindViewHolder(holder: AvenuesViewHolder, position: Int) {
        holder.avenues_image.setImageResource(imagelist[position])
        holder.itemView.setOnClickListener {
            val mainItent = Intent(context, AcademyDetailsActivity::class.java)
            context.startActivity(mainItent)
        }

    }

    override fun getItemCount(): Int {
        return imagelist.size
    }

    inner class AvenuesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var avenues_image: ImageView = itemView.findViewById(R.id.avenues_image)

    }


}