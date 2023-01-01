package com.nmssalman.sampleroomdb.fragments.retrofit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.nmssalman.sampleroomdb.R
import com.nmssalman.sampleroomdb.api.RetrofitInstance
import com.nmssalman.sampleroomdb.databinding.FragmentRetrofitBinding
import kotlinx.android.synthetic.main.fragment_retrofit.*
import java.io.IOException
import java.lang.Exception

class RetrofitFragment : Fragment() {

    private lateinit var todoAdapter: TodoAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_retrofit, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        lifecycleScope.launchWhenCreated {
            val response = try{
                RetrofitInstance.api.getTodos()
            }
            catch (ex: IOException){
                return@launchWhenCreated
            }
            if(response.isSuccessful && response.body() != null)
            {
                sampleText.setText("Hello World New")
                Log.i("ResponseAPI", response.isSuccessful.toString())
                todoAdapter.todos = response.body()!!
            }
        }
    }

    private fun setupRecyclerView() = recycleView.apply {
        todoAdapter = TodoAdapter()
        adapter = todoAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }

}