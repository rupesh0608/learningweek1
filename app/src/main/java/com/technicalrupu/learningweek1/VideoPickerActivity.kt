package com.technicalrupu.learningweek1

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import com.technicalrupu.learningweek1.Helper.Button
import com.technicalrupu.learningweek1.Helper.Permission
import com.technicalrupu.learningweek1.Helper.Picker

class VideoPickerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_picker)

        title = "Video Picker Activity"

        val btn = Button(this)
        val btnVideoPicker = btn.create(R.id.btnVideoPicker)
        btnVideoPicker.setOnClickListener {

            val permission=Permission(this)
            val code=permission.check(android.Manifest.permission.READ_EXTERNAL_STORAGE,101)
            if(code==200)
            {
                val picker=Picker(this)
                picker.externalStorageVideos(1)
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == 1) {
            val uri = data?.data
            val videoView=com.technicalrupu.learningweek1.Helper.VideoView(this)
            if (uri != null) {
                videoView.start(R.id.videoPlayer,uri)
            }
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        val permission=Permission(this)
       val code= permission.result(101,android.Manifest.permission.READ_EXTERNAL_STORAGE,requestCode,grantResults)
        if(code==200)
        {
            val picker=Picker(this)
            picker.externalStorageVideos(1)
        }
    }
}