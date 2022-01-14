package com.technicalrupu.learningweek1.Helper

import android.app.Activity
import android.content.Intent
import android.provider.MediaStore

class Camera(val ref:Activity) {

    fun open()
    {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        ref.startActivityForResult(takePictureIntent, 1)
    }
}