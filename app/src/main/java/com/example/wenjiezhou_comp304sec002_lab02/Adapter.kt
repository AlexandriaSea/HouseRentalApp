package com.example.wenjiezhou_comp304sec002_lab02

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.content.Context

class Adapter(private val context: Context, private val houseList: List<House>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.house_listing, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val house = houseList[position]

        holder.checkBox.isChecked = house.isSelected
        holder.textView.text = house.information
        holder.imageView.setImageResource(house.imageResId)

        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            house.isSelected = isChecked
            if (isChecked) {
                Preference.saveSelectedHouse(context, house.information)
            } else {
                Preference.removeSelectedHouse(context, house.information)
            }
        }
    }

    override fun getItemCount(): Int {
        return houseList.size
    }

    fun getSelectedHouses(): List<String> {
        return Preference.getSelectedHouses(context)
    }
}