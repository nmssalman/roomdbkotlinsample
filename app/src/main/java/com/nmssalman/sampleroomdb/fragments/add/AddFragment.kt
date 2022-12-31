package com.nmssalman.sampleroomdb.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.nmssalman.sampleroomdb.R
import com.nmssalman.sampleroomdb.dataclasses.User
import com.nmssalman.sampleroomdb.model.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*


class AddFragment : Fragment() {
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        // Inflate the layout for this fragment
       mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        view.findViewById<Button>(R.id.btnAdd).setOnClickListener {
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {
        val firstName = editFirstName.text.toString()
        val lastName = editLastName.text.toString()
        val age = editAge.text.toString()

        if(inputNullCheck(firstName, lastName, age)){
            val user = User(0, firstName, lastName, age.toInt())
            mUserViewModel.addUser(user)
            findNavController().navigate(R.id.listFragment)
        }
    }

    private fun inputNullCheck(firstName: String, lastName: String, age: String): Boolean {
        return !firstName.isNullOrEmpty() && !lastName.isNullOrEmpty() && !age.isNullOrEmpty()
    }

}