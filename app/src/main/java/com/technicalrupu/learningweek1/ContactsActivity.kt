package com.technicalrupu.learningweek1

import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract

import android.database.Cursor
import androidx.recyclerview.widget.LinearLayoutManager
import com.technicalrupu.learningweek1.ContactActivity.ContactDetails
import com.technicalrupu.learningweek1.ContactActivity.ContactRecyclerViewAdapter
import com.technicalrupu.learningweek1.Helper.Contact
import com.technicalrupu.learningweek1.Helper.Permission


class ContactsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
        title = "Contacts"
        val permission = Permission(this)
        val code = permission.check(android.Manifest.permission.READ_CONTACTS, 101)
        if (code == 200) {
            val contact= Contact(this)
            val contactList: ArrayList<ContactDetails> = contact.getContactList()
            val adapter = ContactRecyclerViewAdapter(this, contactList)
            val recyclerview = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recyclerview)
            recyclerview.layoutManager = LinearLayoutManager(this)
            recyclerview.adapter = adapter
        }


    }

    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        val permission = Permission(this)
        val code = permission.result(
            101,
            android.Manifest.permission.READ_CONTACTS,
            requestCode,
            grantResults
        )
        if (code == 200) {
            val contact= Contact(this)
            val contactList: ArrayList<ContactDetails> = contact.getContactList()
            val adapter = ContactRecyclerViewAdapter(this, contactList)
            val recyclerview = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recyclerview)
            recyclerview.layoutManager = LinearLayoutManager(this)
            recyclerview.adapter = adapter
        }
    }
}