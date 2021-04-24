package com.jkapps.leroymerlintask.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jkapps.leroymerlintask.entity.CatalogItem
import com.jkapps.leroymerlintask.R

class CatalogItemAdapter(private val items : List<CatalogItem>) : RecyclerView.Adapter<CatalogItemAdapter.CatalogItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_catalog, parent, false)
        return CatalogItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatalogItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class CatalogItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivPhoto : ImageView = itemView.findViewById(R.id.iv_photo)
        private val tvPrice : TextView = itemView.findViewById(R.id.tv_price)
        private val tvName : TextView = itemView.findViewById(R.id.tv_name)

        fun bind(item : CatalogItem) {
            tvPrice.text = item.price
            tvName.text = item.name
            //TODO Replace with a real image
            ivPhoto.setImageResource(R.mipmap.plant)
        }
    }

}