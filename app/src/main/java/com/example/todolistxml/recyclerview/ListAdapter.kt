package com.example.todolistxml.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistxml.R
import com.example.todolistxml.data.model.Priority
import com.example.todolistxml.data.room.TodoEntity

class ListAdapter : RecyclerView.Adapter<MyViewHolder>() {
    var dataList = emptyList<TodoEntity>()

    fun setData(todoList: List<TodoEntity>) {
        this.dataList = todoList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int,
    ) {
        holder.title.text = dataList[position].title
        holder.description.text = dataList[position].description

        when (dataList[position].priority) {
            Priority.LOW ->
                holder.priority.setCardBackgroundColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.green,
                    ),
                )
            Priority.MEDIUM ->
                holder.priority.setCardBackgroundColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.yellow,
                    ),
                )
            Priority.HIGH ->
                holder.priority.setCardBackgroundColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.red,
                    ),
                )
        }
    }
}
