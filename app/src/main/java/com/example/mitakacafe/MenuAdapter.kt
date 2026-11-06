package com.example.mitakacafe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class MenuModel(
    val image: Int,
    val title: String,
    val desc: String,
    val price: String
)

class MenuAdapter(
    private val listMenu: List<MenuModel>,
    private val onItemClick: (MenuModel) -> Unit
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgMenu: ImageView = itemView.findViewById(R.id.imgMenu)
        val tvTitle: TextView = itemView.findViewById(R.id.tvMenuTitle)
        val tvDesc: TextView = itemView.findViewById(R.id.tvMenuDesc)
        val tvPrice: TextView = itemView.findViewById(R.id.tvMenuPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val menu = listMenu[position]
        holder.imgMenu.setImageResource(menu.image)
        holder.tvTitle.text = menu.title
        holder.tvDesc.text = menu.desc
        holder.tvPrice.text = menu.price
        holder.itemView.setOnClickListener {
            onItemClick(menu)
        }
    }

    override fun getItemCount(): Int = listMenu.size
}
