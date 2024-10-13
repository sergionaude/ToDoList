package com.example.todolistxml.data.model

import androidx.room.TypeConverter

class Converter {
    @TypeConverter
    fun fromEnum(priority: Priority) = priority.name

    @TypeConverter
    fun fromString(stringValue: String) = Priority.valueOf(stringValue)
}
