package com.example.todolistxml

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.todolistxml.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    val  listBinding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentListBinding.inflate(layoutInflater)

        // Inflate the layout for this fragment
        _binding?.button?.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_editFragment)
        }

        return listBinding?.root
    }
}