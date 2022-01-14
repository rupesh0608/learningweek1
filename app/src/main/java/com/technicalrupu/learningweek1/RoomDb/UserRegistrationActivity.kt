package com.technicalrupu.learningweek1.RoomDb

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.technicalrupu.learningweek1.R

class UserRegistrationActivity : AppCompatActivity() {
    private lateinit var edtName: EditText
    private lateinit var edtPhone: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_registration)

         var id:Int=0
         edtName = findViewById(R.id.edtName)
        edtPhone = findViewById(R.id.edtPhone)
        val button = findViewById<Button>(R.id.btn_save)

        if(intent.getStringExtra("name")!=null || intent.getStringExtra("phone")!=null || intent.getIntExtra("id",-1)!=-1)
        {
            val name=intent.getStringExtra("name")
            edtName.setText(name.toString())
            val phone=intent.getStringExtra("phone")
            edtPhone.setText(phone.toString())
            id=intent.getIntExtra("id",-1)
            button.text = "Update"
        }


        button.setOnClickListener {

            val replyIntent = Intent()
            if (TextUtils.isEmpty(edtName.text) ||TextUtils.isEmpty(edtPhone.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val name = edtName.text.toString()
                val phone = edtPhone.text.toString()
                replyIntent.putExtra(EXTRA_REPLY_ID, id.toString())
                replyIntent.putExtra(EXTRA_REPLY_NAME, name)
                replyIntent.putExtra(EXTRA_REPLY_PHONE, phone)
                setResult(Activity.RESULT_OK, replyIntent)

            }
            finish()
        }
    }
    companion object {
        const val EXTRA_REPLY_NAME = "name"
        const val EXTRA_REPLY_STATUS = "status"
        const val EXTRA_REPLY_PHONE = "phone"
        const val EXTRA_REPLY_ID = "id"
    }
}