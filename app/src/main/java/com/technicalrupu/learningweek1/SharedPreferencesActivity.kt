package com.technicalrupu.learningweek1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SharedPreferencesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_prefrences)
        title = "Shared Preferences"

        val btn = com.technicalrupu.learningweek1.Helper.Button(this)
        val insert = btn.create(R.id.btn_insert)
        insert.setOnClickListener {
            val edtName = findViewById<EditText>(R.id.edtName)
            var edtPhone = findViewById<EditText>(R.id.edtPhone)
            if(TextUtils.isEmpty(edtName.text.toString())||TextUtils.isEmpty(edtPhone.text.toString())) {
                Toast.makeText(this,"Invalid inputs",Toast.LENGTH_SHORT).show()
            }else {
                val sharedPref = this.getSharedPreferences(
                    "file_name", Context.MODE_PRIVATE
                )
                sharedPref.edit()
                    .putString("name", edtName.text.toString())
                    .putString("phone", edtPhone.text.toString())
                    .apply()
                edtName.setText("")
                edtPhone.setText("")
                Toast.makeText(this,"Saved Successfully",Toast.LENGTH_SHORT).show()

            }
        }
        val fetch = btn.create(R.id.btn_fetch)
        fetch.setOnClickListener {
            val sharedPref = this.getSharedPreferences(
                "file_name", Context.MODE_PRIVATE
            )
            val name=sharedPref.getString("name","Name")
            val phone=sharedPref.getString("phone","Phone")
            val output=findViewById<TextView>(R.id.output)
            if(TextUtils.isEmpty(name)||TextUtils.isEmpty(phone))
            {
                output.text="No Output"
            }else{
                output.text="Name: "+name+"\n"+"Phone Number: "+phone
            }
        }
    }
}