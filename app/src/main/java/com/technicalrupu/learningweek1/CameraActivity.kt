package com.technicalrupu.learningweek1

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.AsyncTask
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.technicalrupu.learningweek1.Helper.*
import android.provider.MediaStore

import android.content.ContentValues

import android.net.Uri

import android.os.Environment
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.OutputStream
import java.lang.Exception


class CameraActivity : AppCompatActivity() {

    val CAMERA_RQ=101
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        title = "Camera"

        val btn = Button(this)
        val btnCamera = btn.create(R.id.btnCamera)
        btnCamera.setOnClickListener {
                 val permission=Permission(this)
           val code= permission.check(android.Manifest.permission.CAMERA,CAMERA_RQ)
            if(code==200)
            {
                Camera(this).open()
            }
        }

    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode ==1 && resultCode == RESULT_OK) {
            val imageView=findViewById<ImageView>(R.id.image)
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)
            val drawable = imageView.drawable as BitmapDrawable
            val bitmap = drawable.bitmap
            val backgroundTask=BackgroundTask(bitmap)
            backgroundTask.execute(100)

        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        val permission=Permission(this)
       val code= permission.result(CAMERA_RQ,android.Manifest.permission.CAMERA,requestCode,grantResults)
        if(code==200)
        {
           val cam=Camera(this)
           cam.open()
        }
    }



    @SuppressLint("StaticFieldLeak")
    inner class BackgroundTask(val bitmap: Bitmap):AsyncTask<Int,Int,Void>(){

        override fun doInBackground(vararg params: Int?): Void? {
            val file=File(this@CameraActivity)
               file.saveImage(bitmap)
            return null
        }

        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun onPostExecute(result: Void?) {
            val toast=ToastClass(this@CameraActivity)
            toast.simpleToast("Successfully Image Saved", Toast.LENGTH_SHORT)
            super.onPostExecute(result)
        }

        override fun onProgressUpdate(vararg values: Int?) {
            val toast=ToastClass(this@CameraActivity)
            toast.simpleToast("Saving Image....", Toast.LENGTH_SHORT)
            super.onProgressUpdate(*values)
        }

        override fun onCancelled(result: Void?) {
            val toast=ToastClass(this@CameraActivity)
            toast.simpleToast("Failed to save Image", Toast.LENGTH_SHORT)
            super.onCancelled(result)

        }

        override fun onCancelled() {
            val toast=ToastClass(this@CameraActivity)
            toast.simpleToast("Failed to save Image", Toast.LENGTH_SHORT)
            super.onCancelled()
        }
    }
}