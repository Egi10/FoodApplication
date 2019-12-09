package com.example.foodapplication.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapplication.R
import com.example.foodapplication.network.model.CategoriesItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_food.view.*

class FoodAdapter(private val item: List<CategoriesItem>, private val listener: (CategoriesItem) -> Unit)
    : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_food, parent, false))

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(item[position], listener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(categoriesItem: CategoriesItem, listener: (CategoriesItem) -> Unit) {
            itemView.tvTitle.text = categoriesItem.strCategory
            itemView.tvDeskripsi.text = categoriesItem.strCategoryDescription
            Picasso.get().load(categoriesItem.strCategoryThumb).into(itemView.ivImage)

            itemView.setOnClickListener {
                listener(categoriesItem)
            }
        }
    }
}