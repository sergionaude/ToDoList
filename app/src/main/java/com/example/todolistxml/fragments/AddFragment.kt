package com.example.todolistxml.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.todolistxml.R
import com.example.todolistxml.data.room.TodoEntity
import com.example.todolistxml.databinding.FragmentAddBinding
import com.example.todolistxml.utils.dataValidation
import com.example.todolistxml.utils.getAdapter
import com.example.todolistxml.utils.parsePriority
import com.example.todolistxml.viewmodel.ToDoViewModel

class AddFragment : Fragment() {
    private val viewModel: ToDoViewModel by viewModels()

    private var updateBinding: FragmentAddBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        updateBinding = FragmentAddBinding.inflate(layoutInflater)

        updateBinding?.spinnerPriority?.onItemSelectedListener = getAdapter(requireContext())

        setHasOptionsMenu(true)

        return updateBinding?.root
    }

    override fun onCreateOptionsMenu(
        menu: Menu,
        inflater: MenuInflater,
    ) {
        inflater.inflate(R.menu.add_fragment_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_add) {
            insertDataToDB()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun insertDataToDB() {
        val mTitle = updateBinding?.etTitle?.text.toString()
        val mPriority = updateBinding?.spinnerPriority?.selectedItem.toString()
        val mDescription = updateBinding?.etDescription?.text.toString()

        val validation = dataValidation(mTitle, mDescription)

        if (validation) {
            val newToDo =
                TodoEntity(
                    id = 0,
                    title = mDescription,
                    priority = parsePriority(mPriority),
                    description = mDescription,
                )
            viewModel.insertToDo(newToDo)
            Toast.makeText(context, "Succesfully added", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(context, "An error has happen", Toast.LENGTH_SHORT).show()
        }
    }
}
