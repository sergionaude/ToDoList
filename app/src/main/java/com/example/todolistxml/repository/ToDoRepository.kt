package com.example.todolistxml.repository

import com.example.todolistxml.data.room.TodoDAO
import com.example.todolistxml.data.room.TodoEntity

class ToDoRepository(
    private val todoDAO: TodoDAO,
) {
    fun getAllData() = todoDAO.getAllData()

    suspend fun insertData(todoEntity: TodoEntity) = todoDAO.insert(todoEntity = todoEntity)
}
