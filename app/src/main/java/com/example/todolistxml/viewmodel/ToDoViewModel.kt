package com.example.todolistxml.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.todolistxml.data.room.ToDoDatabase
import com.example.todolistxml.data.room.TodoEntity
import com.example.todolistxml.repository.ToDoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoViewModel(
    application: Application,
) : AndroidViewModel(application) {
    private val todoDao = ToDoDatabase.getDataBase(application).todoDAO()

    private val repository: ToDoRepository

    val getAllTodo: LiveData<List<TodoEntity>>

    init {
        repository = ToDoRepository(todoDAO = todoDao)

        getAllTodo = repository.getAllData()
    }

    fun insertToDo(todoEntity: TodoEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertData(todoEntity = todoEntity)
        }
    }
}
