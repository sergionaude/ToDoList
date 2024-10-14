package com.example.todolistxml.utils

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.todolistxml.R
import com.example.todolistxml.data.model.Priority

fun dataValidation(
    mTitle: String,
    mDescription: String,
): Boolean = !(mTitle.isEmpty() || mDescription.isEmpty())

fun parsePriority(priority: String): Priority =
    when (priority) {
        "High Priority" -> {
            Priority.HIGH
        }
        "Medium Priority" -> {
            Priority.MEDIUM
        }
        "Low Priority" -> {
            Priority.LOW
        }
        else -> Priority.LOW
    }

fun getAdapter(context: Context): AdapterView.OnItemSelectedListener {
    val listener: AdapterView.OnItemSelectedListener =
        object :
            AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {}

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long,
            ) {
                when (position) {
                    0 -> {
                        (parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(context, R.color.red))
                    }
                    1 -> {
                        (parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(context, R.color.yellow))
                    }
                    2 -> {
                        (parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(context, R.color.green))
                    }
                }
            }
        }
    return listener
}
