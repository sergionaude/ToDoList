package com.example.todolistxml.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.todolistxml.R
import com.example.todolistxml.databinding.FragmentAddBinding

class AddFragment : Fragment() {
    private var updateBinding: FragmentAddBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        updateBinding = FragmentAddBinding.inflate(layoutInflater)

        setHasOptionsMenu(true)

        return updateBinding?.root
    }

    override fun onCreateOptionsMenu(
        menu: Menu,
        inflater: MenuInflater,
    ) {
        inflater.inflate(R.menu.add_fragment_menu, menu)
    }
}
