package com.example.todolistxml.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolistxml.R
import com.example.todolistxml.databinding.FragmentListBinding
import com.example.todolistxml.recyclerview.ListAdapter
import com.example.todolistxml.viewmodel.ToDoViewModel

class ListFragment : Fragment() {
    private val viewModel: ToDoViewModel by viewModels()
    private var listBinding: FragmentListBinding? = null
    private val listAdapter: ListAdapter by lazy { ListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        listBinding = FragmentListBinding.inflate(layoutInflater)
        listBinding?.addButton?.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        listBinding?.recyclerView?.adapter = listAdapter
        listBinding?.recyclerView?.layoutManager = LinearLayoutManager(requireActivity())
        viewModel.getAllTodo.observe(viewLifecycleOwner) { data ->
            listAdapter.setData(data)
        }

        setHasOptionsMenu(true)

        return listBinding?.root
    }

    override fun onCreateOptionsMenu(
        menu: Menu,
        inflater: MenuInflater,
    ) {
        inflater.inflate(R.menu.list_fragment_menu, menu)
    }
}
