package com.example.todolistxml.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TodoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todoEntity: TodoEntity)

    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllData(): LiveData<List<TodoEntity>>
}
