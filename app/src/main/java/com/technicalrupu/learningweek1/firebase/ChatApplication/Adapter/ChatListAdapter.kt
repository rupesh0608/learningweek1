package com.technicalrupu.learningweek1.firebase.ChatApplication.Adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.technicalrupu.learningweek1.R
import com.technicalrupu.learningweek1.firebase.ChatApplication.Chats

class ChatListAdapter(val list: ArrayList<Chats>):RecyclerView.Adapter<ChatListAdapter.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        if(list[position].type==0)
        {
            return 0
        }else{
            return  1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view1 = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chatlist_msg, parent, false)
        val view2 = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chatlist_reply, parent, false)

        return if(viewType==0) {
            ViewHolder(view1)
        }else{
            ViewHolder(view2)
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = list[position]

        holder.txtMsg.text = list[position].msg
    }
    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val txtMsg=ItemView.findViewById<TextView>(R.id.txtMsg)
        init {
            itemView.setOnClickListener{

            }
        }

    }

    class ViewHolder2(ItemView: View): RecyclerView.ViewHolder(ItemView) {
        val txtMsg=ItemView.findViewById<TextView>(R.id.txtMsg)
        init {

        }
    }
}
