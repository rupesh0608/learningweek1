package com.technicalrupu.learningweek1

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

class RecyclerViewAdapter(var context: Context, val list: ArrayList<Car>):RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view1, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = list[position]

        holder.textView.text = ItemsViewModel.title
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = itemView.findViewById(R.id.text)

         init {
             itemView.setOnClickListener{
                 Toast.makeText(ItemView.context, "item "+(adapterPosition+1),Toast.LENGTH_SHORT).show()
             }
         }

    }
}
