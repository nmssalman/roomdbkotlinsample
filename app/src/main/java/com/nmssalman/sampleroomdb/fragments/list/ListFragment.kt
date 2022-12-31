package com.nmssalman.sampleroomdb.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.nmssalman.sampleroomdb.R
import com.nmssalman.sampleroomdb.model.UserViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        view.findViewById<FloatingActionButton>(R.id.floatingActionButton2).setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        view.findViewById<FloatingActionButton>(R.id.deleteAllUsers).setOnClickListener {
            mUserViewModel.deleteAllUsers()
        }
        val adapter = ListAdapter()
        val recyclerView = view.recycleView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer {user ->
            adapter.setData(user)
        })
        // Inflate the layout for this fragment
        return view
    }

}