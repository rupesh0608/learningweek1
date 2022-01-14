package com.technicalrupu.learningweek1.ContactActivity

import com.technicalrupu.learningweek1.R


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.technicalrupu.learningweek1.ListView.Car
import com.technicalrupu.learningweek1.RecyclerView.GridRecyclerViewActivity

class ContactRecyclerViewAdapter(var context: Context, val list: ArrayList<ContactDetails>):RecyclerView.Adapter<ContactRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_recyclerview_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = list[position]

        holder.txtName.text = ItemsViewModel.name
        holder.txtPhone.text = ItemsViewModel.phoneNumber
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val txtName: TextView = itemView.findViewById(R.id.txtName)
        val txtPhone: TextView = itemView.findViewById(R.id.txtPhone)

        init {
//            itemView.setOnClickListener{
//                Toast.makeText(ItemView.context, "item "+(adapterPosition+1),Toast.LENGTH_SHORT).show()
//            }
        }

    }
}
