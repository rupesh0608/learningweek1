package com.technicalrupu.learningweek1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.technicalrupu.learningweek1.Helper.Button
import com.technicalrupu.learningweek1.RoomDb.*
import com.technicalrupu.learningweek1.RoomDb.Tables.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import java.lang.Exception

class RoomDbActivity : AppCompatActivity() {

    private val CODE_INSERT = 1
    private val CODE_UPDATE = 2
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { UserDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { UserRepository(database.userDao()) }

    private val userViewModel: UserViewModel by viewModels {
        UserViewModelFactory((application as UserApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_db)
        title = "Room Database"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = UserListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        userViewModel.allUsers.observe(this) { users ->
            users.let { adapter.submitList(it) }
        }
         val btn=Button(this)
       val btnInsert= btn.create(R.id.btnInsert)
        btnInsert.setOnClickListener {
            val intent = Intent(this, UserRegistrationActivity::class.java)
            startActivityForResult(intent, CODE_INSERT)
        }
        val btnDelete= btn.create(R.id.btnDelete)
        btnDelete.setOnClickListener {
            userViewModel.delete()
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CODE_INSERT && resultCode == Activity.RESULT_OK) {
            var name = ""
            var phone = ""
            data?.getStringExtra(UserRegistrationActivity.EXTRA_REPLY_NAME)?.let {
                name = it
            }
            data?.getStringExtra(UserRegistrationActivity.EXTRA_REPLY_PHONE)?.let {
                phone = it
            }
            val user = User(name, phone.toLong())
            userViewModel.insert(user)

        }
        if (requestCode == CODE_UPDATE && resultCode == Activity.RESULT_OK) {

                var name = ""
                var phone = ""
                var id: Int=-1
                data?.getStringExtra(UserRegistrationActivity.EXTRA_REPLY_NAME)?.let {
                    name = it
                }
                data?.getStringExtra(UserRegistrationActivity.EXTRA_REPLY_PHONE)?.let {
                    phone = it
                }
                data?.getStringExtra(UserRegistrationActivity.EXTRA_REPLY_ID)?.let {
                    id = it.toInt()
                }
            userViewModel.update(id, name, phone.toLong())
        }


    }

}