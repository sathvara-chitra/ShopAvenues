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
import com.dexterapp.shopavenues.activity.CelebrityDetailsActivity
import com.dexterapp.shopavenues.activity.ProductDetailsActivity

class CelebrityListAdapter(
    var arrayAvenue: ArrayList<String>,
    var context: Context

) :
    RecyclerView.Adapter<CelebrityListAdapter.AvenuesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvenuesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.celebrity_item, parent, false)
        return AvenuesViewHolder(view)
    }

    override fun onBindViewHolder(holder: AvenuesViewHolder, position: Int) {
//        holder.image.setImageResource(imagelist[position])
        holder.txtName.setText(arrayAvenue!!.get(position))

        holder.itemView.setOnClickListener {
          val mainINtent = Intent(context, CelebrityDetailsActivity::class.java)
            context.startActivity(mainINtent)
        }

    }

    override fun getItemCount(): Int {
        return arrayAvenue.size
    }

    inner class AvenuesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image: ImageView = itemView.findViewById(R.id.avenues_image)
        var txtName: TextView = itemView.findViewById(R.id.txtName)

    }



}