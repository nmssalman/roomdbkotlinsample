package com.nmssalman.sampleroomdb.fragments.list

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.nmssalman.sampleroomdb.R
import com.nmssalman.sampleroomdb.dataclasses.User
import kotlinx.android.synthetic.main.item_list.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))
     }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        with(holder.itemView)
        {
            with(currentItem)
            {
                textFirstName.text = firstName
                textLastName.text = lastName
                textAge.text = age.toString()
                textID.text = id.toString()
            }
        }
        holder.itemView.row.setOnClickListener {
            val i = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(i)
        }

     }
    fun setData(user: List<User>)
    {
        this.userList = user
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return userList.size
     }
}