package com.example.todolistxml.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.todolistxml.R
import com.example.todolistxml.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private var listBinding: FragmentListBinding? = null

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
        listBinding?.imageView?.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_updateFragment)
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
