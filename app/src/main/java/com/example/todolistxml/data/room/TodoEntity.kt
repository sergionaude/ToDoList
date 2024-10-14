package com.example.todolistxml.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todolistxml.data.model.Priority

@Entity(tableName = "todo_table")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val priority: Priority,
    val description: String,
)
