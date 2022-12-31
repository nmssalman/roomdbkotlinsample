package com.nmssalman.sampleroomdb.fragments.update

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.nmssalman.sampleroomdb.R
import com.nmssalman.sampleroomdb.model.UserViewModel
import com.nmssalman.sampleroomdb.dataclasses.User
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.editFirstName
import kotlinx.android.synthetic.main.fragment_update.editLastName
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {
    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var mUserViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)
        // Inflate the layout for this fragment
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        view.findViewById<Button>(R.id.btnUpdate).setOnClickListener {
            updateUser()
        }
        view.findViewById<Button>(R.id.btnDelete).setOnClickListener {
            deleteUser()
        }
        view.editFirstName.setText(args.user.firstName)
        view.editLastName.setText(args.user.lastName)
        view.updateAge.setText(args.user.age.toString())
        return view
    }

    private fun deleteUser() {
        val firstname = editFirstName.text.toString()
        val lastname = editLastName.text.toString()
        val age = updateAge.text.toString()
        if(inputNullCheck(firstname, lastname, age))
        {
            val deleteUser = User(args.user.id,firstname, lastname, age.toInt())
            mUserViewModel.deleteUser(deleteUser)
            findNavController().navigate(R.id.listFragment)
        }
    }

    private fun updateUser() {
        val firstname = editFirstName.text.toString()
        val lastname = editLastName.text.toString()
        val age = updateAge.text.toString()
        if (inputNullCheck(firstname, lastname, age))
        {
            val updateUser = User(args.user.id,firstname, lastname, age.toInt())
            mUserViewModel.updateUser(updateUser)
            findNavController().navigate(R.id.listFragment)
        }
    }
    private fun inputNullCheck(firstName: String, lastName: String, age: String): Boolean {
        return !firstName.isNullOrEmpty() && !lastName.isNullOrEmpty() && !age.isNullOrEmpty()
    }
}