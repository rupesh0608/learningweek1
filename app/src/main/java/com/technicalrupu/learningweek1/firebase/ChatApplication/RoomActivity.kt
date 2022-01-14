package com.technicalrupu.learningweek1.firebase.ChatApplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.technicalrupu.learningweek1.R
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import com.google.firebase.database.DatabaseError

import com.google.firebase.database.DataSnapshot

import com.google.firebase.database.ChildEventListener
class RoomActivity : AppCompatActivity() {

    lateinit var userName:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        val btnAddRoom = findViewById<ImageView>(R.id.btnAddRoom)

        val edtRoomName = findViewById<EditText>(R.id.edtRoomTextBox)
        val listView = findViewById<ListView>(R.id.roomListView)


        val root = FirebaseDatabase.getInstance().reference.root
        val roomList = ArrayList<String>()


        val arrayAdapter =
            ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, roomList)
        listView.adapter = arrayAdapter
        btnAddRoom.setOnClickListener {
            val map = HashMap<String, Any>()
            map[edtRoomName.text.toString()] = ""
            edtRoomName.setText("")
            root.updateChildren(map)
        }
        root.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val set: MutableSet<String> = HashSet()
                val i: Iterator<*> = dataSnapshot.children.iterator()
                while (i.hasNext()) {
                    (i.next() as DataSnapshot).key?.let { set.add(it) }
                }
                roomList.clear()
                roomList.addAll(set)
                arrayAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })


        listView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(applicationContext, ChatRoomActivity::class.java)
            intent.putExtra("room_name", (view as TextView).text.toString())
            intent.putExtra("user_name", userName)
            startActivity(intent)
        }

        requestUserName()

    }

    private fun requestUserName() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Enter Name:").setCancelable(false)

        val inputBox = EditText(this)
        builder.setView(inputBox)
        builder.setPositiveButton("OK") { d, _ ->
           userName = inputBox.text.toString()
        }
        builder.setNegativeButton("Cancel") { d, _ ->
            d.dismiss()
            requestUserName()
        }
        builder.show()
    }
}