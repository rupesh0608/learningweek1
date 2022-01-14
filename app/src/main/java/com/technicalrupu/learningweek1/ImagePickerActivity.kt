package com.technicalrupu.learningweek1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.technicalrupu.learningweek1.Helper.Button
import com.technicalrupu.learningweek1.Helper.Permission
import com.technicalrupu.learningweek1.Helper.Picker

class ImagePickerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_picker)
        title="Image Picker"

        val btn=Button(this)
       val btnImagePicker= btn.create(R.id.btnImagePicker)
        btnImagePicker.setOnClickListener {

            val permission=Permission(this)
            val code=permission.check(android.Manifest.permission.READ_EXTERNAL_STORAGE,101)
            if(code==200)
            {
                val pick= Picker(this)
                pick.externalStorageImages(1)
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode== RESULT_OK && requestCode==1)
        {
           val imageUri=data?.data
            val imageView=findViewById<ImageView>(R.id.image)
            imageView.setImageURI(imageUri)
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        val permission=Permission(this)
        val code=permission.result(101,android.Manifest.permission.READ_EXTERNAL_STORAGE ,requestCode,grantResults)
        if(code==200)
        {
            val pick= Picker(this)
            pick.externalStorageImages(1)
        }
    }
}