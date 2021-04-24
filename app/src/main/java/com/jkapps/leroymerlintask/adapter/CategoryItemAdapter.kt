package com.jkapps.leroymerlintask.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jkapps.leroymerlintask.entity.CategoryItem
import com.jkapps.leroymerlintask.R

class CategoryItemAdapter(private val categories: List<CategoryItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> R.layout.item_category_header
            itemCount - 1 -> R.layout.item_categoty_footer
            else -> R.layout.item_category
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            R.layout.item_category_header -> HeaderViewHolder(itemView = inflater.inflate(R.layout.item_category_header, parent, false))
            R.layout.item_category -> CategoryItemViewHolder(itemView = inflater.inflate(R.layout.item_category, parent, false))
            R.layout.item_categoty_footer -> FooterViewHolder(itemView = inflater.inflate(R.layout.item_categoty_footer, parent, false))
            else -> throw IllegalArgumentException("No such view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CategoryItemViewHolder) {
            val correctPosition = position - 1
            holder.bind(categories[correctPosition])
        }
    }

    override fun getItemCount(): Int {
        return categories.size + 2
    }

    class CategoryItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvName: TextView = itemView.findViewById(R.id.tv_name)
        private val ivPhoto: ImageView = itemView.findViewById(R.id.iv_photo)

        fun bind(category: CategoryItem) {
            tvName.text = category.title
            //TODO Replace with a real image
            ivPhoto.setImageResource(R.mipmap.plant)
        }
    }

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    class FooterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}