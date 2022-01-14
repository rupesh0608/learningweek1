package com.technicalrupu.learningweek1.RoomDb

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.technicalrupu.learningweek1.R
import com.technicalrupu.learningweek1.RoomDb.Tables.User
import java.lang.Exception

class UserListAdapter(val activity: android.app.Activity) :
    ListAdapter<User, UserListAdapter.UserViewHolder>(WordsComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current, activity)
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtName: TextView = itemView.findViewById(R.id.txtName)
        private val txtPhone: TextView = itemView.findViewById(R.id.txtPhone)
        fun bind(user: User, activity: android.app.Activity) {

            txtName.text = user.name
            txtPhone.text = user.phone.toString()

            itemView.setOnClickListener {
                val CODE_UPDATE = 2
                val intent = Intent(itemView.context, UserRegistrationActivity::class.java)
                intent.putExtra("name", user.name)
                intent.putExtra("id", user.id)
                intent.putExtra("phone", user.phone.toString())
                activity.startActivityForResult(intent, CODE_UPDATE)
            }
        }

        companion object {
            fun create(parent: ViewGroup): UserViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.user_recyclerview_item, parent, false)
                return UserViewHolder(view)
            }
        }

    }

    class WordsComparator : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.name == newItem.name
        }
    }
}