package com.example.todolistxml.recyclerview

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistxml.R

class MyViewHolder(
    itemView: View,
) : RecyclerView.ViewHolder(itemView) {
    var title: TextView
    var description: TextView
    var priority: CardView

    init {
        title = itemView.findViewById(R.id.todo_title)
        description = itemView.findViewById(R.id.todo_description)
        priority = itemView.findViewById(R.id.todo_priority_indicator)
    }
}
