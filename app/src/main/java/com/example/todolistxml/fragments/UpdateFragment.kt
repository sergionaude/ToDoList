package com.example.todolistxml.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.todolistxml.R
import com.example.todolistxml.databinding.FragmentUpdateBinding
import com.example.todolistxml.utils.getAdapter

class UpdateFragment : Fragment() {
    private var editBinding: FragmentUpdateBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        editBinding = FragmentUpdateBinding.inflate(layoutInflater)

        editBinding?.currentPriority?.onItemSelectedListener = getAdapter(requireContext())

        setHasOptionsMenu(true)

        return editBinding?.root
    }

    override fun onCreateOptionsMenu(
        menu: Menu,
        inflater: MenuInflater,
    ) {
        inflater.inflate(R.menu.update_fragment_menu, menu)
    }
}
