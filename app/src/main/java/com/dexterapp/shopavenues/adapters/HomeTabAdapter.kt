package com.dexterapp.shopavenues.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dexterapp.shopavenues.R
import com.dexterapp.shopavenues.models.tabname

class HomeTabAdapter(var tablist: ArrayList<tabname>?, var context: Context) :
    RecyclerView.Adapter<HomeTabAdapter.HomeTabViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeTabViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.home_tab_item, parent, false)
        return HomeTabViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeTabViewHolder, position: Int) {
        val tablist = tablist?.get(position)
        holder.tabname.text = tablist?.TabName

    }

    override fun getItemCount(): Int {
        return tablist?.size!!
    }

    inner class HomeTabViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tabname: TextView = itemView.findViewById(R.id.tab_name)

    }
}