package com.example.todolistxml.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.todolistxml.data.model.Converter

@Database(entities = [TodoEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun todoDAO(): TodoDAO

    companion object {
        @Volatile
        private var INSTANCE: ToDoDatabase? = null

        fun getDataBase(context: Context): ToDoDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance =
                    Room
                        .databaseBuilder(
                            context = context,
                            ToDoDatabase::class.java,
                            "todo_database",
                        ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
