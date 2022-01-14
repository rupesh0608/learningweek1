package com.technicalrupu.learningweek1.firebase.ChatApplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.technicalrupu.learningweek1.R
import com.technicalrupu.learningweek1.firebase.ChatApplication.Adapter.ChatListAdapter


class ChatRoomActivity : AppCompatActivity() {
    val data = ArrayList<Chats>()
    lateinit var adapter: ChatListAdapter
    lateinit var recyclerview: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_room)
        val userName = intent.extras?.get("user_name").toString()
        val roomName = intent.extras?.get("room_name").toString()
        recyclerview = findViewById(R.id.recyclerview)
        title = roomName

        val btnSend = findViewById<ImageView>(R.id.btnSend)
        val edtMsgBox = findViewById<EditText>(R.id.edtMsgBox)
        val root = FirebaseDatabase.getInstance().reference.child(roomName)

        btnSend.setOnClickListener {
            val map: Map<String, Any> = HashMap()
            val tempKey: String? = root.push().key
            root.updateChildren(map)
            val map2: MutableMap<String, Any> = HashMap()
            map2["name"] = userName
            val msg = edtMsgBox.text.toString()
            map2["msg"] = msg
            tempKey?.let { it1 -> root.child(it1) }?.updateChildren(map2)
            edtMsgBox.setText("")
        }

        root.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                appendChatConversation(snapshot,userName)
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                appendChatConversation(snapshot,userName)
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {

            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun appendChatConversation(dataSnapshot: DataSnapshot,userName:String) {
        val edtTxt=findViewById<TextView>(R.id.txtMsg)
        val i: Iterator<*> = dataSnapshot.children.iterator()
        data.clear()
        while (i.hasNext()) {
            val chatMsg: String = (i.next() as DataSnapshot).value as String
            val chatUserName = (i.next() as DataSnapshot).value as String
            edtTxt.append("$chatUserName : $chatMsg \n")
//            if(userName==chatUserName){
//                data.add(Chats(chatUserName,chatMsg,0))
//            }else{
//                data.add(Chats(chatUserName,chatMsg,1))
//            }
        }
//        adapter = ChatListAdapter(data)
//        recyclerview.layoutManager = LinearLayoutManager(this)
//        recyclerview.adapter=adapter
    }
}