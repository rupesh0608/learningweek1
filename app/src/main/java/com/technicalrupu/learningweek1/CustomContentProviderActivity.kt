package com.technicalrupu.learningweek1

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.technicalrupu.learningweek1.CustomCP.CustomContentProvider

class CustomContentProviderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_content_provider)
        val edtName = findViewById<EditText>(R.id.edtName)
        val edtPhone = findViewById<EditText>(R.id.edtPhone)
        var rs = contentResolver.query(
            CustomContentProvider.CONTENT_URI,
            arrayOf(
                CustomContentProvider._ID,
                CustomContentProvider.NAME,
                CustomContentProvider.PHONE
            ),
            null,
            null,
            CustomContentProvider.NAME
        )

        val btn = com.technicalrupu.learningweek1.Helper.Button(this)

        val btnInsert = btn.create(R.id.btnSubmit)
        btnInsert.setOnClickListener {
            val cv = ContentValues()
            cv.put(CustomContentProvider.NAME, edtName.text.toString())
            cv.put(CustomContentProvider.PHONE, edtPhone.text.toString())
            contentResolver.insert(CustomContentProvider.CONTENT_URI, cv)
            rs?.requery()
            Toast.makeText(applicationContext, "Inserted Successfully", Toast.LENGTH_SHORT).show()
            edtName.setText("")
            edtPhone.setText("")


        }

        val btnUpdate = btn.create(R.id.btnUpdate)
        btnUpdate.setOnClickListener {
            val cv = ContentValues()
            cv.put(CustomContentProvider.NAME, edtName.text.toString())
            cv.put(CustomContentProvider.PHONE, edtPhone.text.toString())
            val condition = CustomContentProvider._ID + "=?"
            val condition_val = arrayOf(rs?.getString(0).toString())
            val check = contentResolver.update(
                CustomContentProvider.CONTENT_URI,
                cv,
                condition,
                condition_val
            )
            rs?.requery()
            if (check > 0) {
                Toast.makeText(applicationContext, "Updated Successfully", Toast.LENGTH_SHORT)
                    .show()
                edtName.setText("")
                edtPhone.setText("")
            } else {
                Toast.makeText(applicationContext, "Failed to Update!..", Toast.LENGTH_SHORT).show()
            }

        }
        val btnDelete = btn.create(R.id.btnDelete)
        btnDelete.setOnClickListener {
            val condition = CustomContentProvider._ID + "=?"
            val condition_val = arrayOf(rs?.getString(0).toString())
            val check = contentResolver.delete(
                CustomContentProvider.CONTENT_URI,
                condition,
                condition_val
            )
            rs?.requery()
            if (check > 0) {
                Toast.makeText(applicationContext, "Deleted Successfully", Toast.LENGTH_SHORT)
                    .show()
                edtName.setText("")
                edtPhone.setText("")
            } else {
                Toast.makeText(applicationContext, "Failed to Update!..", Toast.LENGTH_SHORT).show()
            }

        }

        val btnNext = findViewById<Button>(R.id.btnNext)
        btnNext.setOnClickListener {
            if (rs != null) {
                if (rs.moveToNext()) {
                    edtName.setText(rs.getString(1).toString())
                    edtPhone.setText(rs.getString(2).toString())
                } else {
                    Toast.makeText(applicationContext, "No Data To Show....", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        val btnPrev = findViewById<Button>(R.id.btnPrevious)
        btnPrev.setOnClickListener {
            if (rs != null) {
                if (rs.moveToPrevious()) {
                    edtName.setText(rs.getString(1).toString())
                    edtPhone.setText(rs.getString(2).toString())
                } else {
                    Toast.makeText(applicationContext, "No Data To Show....", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}