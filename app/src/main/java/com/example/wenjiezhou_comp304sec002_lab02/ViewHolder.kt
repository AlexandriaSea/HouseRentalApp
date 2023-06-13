package com.example.wenjiezhou_comp304sec002_lab02

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val checkBox: CheckBox = itemView.findViewById(R.id.checkBoxHouse)
    val textView: TextView = itemView.findViewById(R.id.textViewHouse)
    val imageView: ImageView = itemView.findViewById(R.id.imageViewHouse)
}