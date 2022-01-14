package com.technicalrupu.learningweek1.Helper

import android.app.Activity
import android.content.Intent
import android.provider.MediaStore

class Picker (val ref:Activity){


    fun externalStorageImages(requestCode:Int ){
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        ref.startActivityForResult(intent, requestCode)
    }

    fun externalStorageVideos(requestCode:Int ){
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Video.Media.INTERNAL_CONTENT_URI)
        ref.startActivityForResult(intent, requestCode)
    }
}