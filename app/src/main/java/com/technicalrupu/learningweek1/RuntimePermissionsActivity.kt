package com.technicalrupu.learningweek1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.security.Permission

class RuntimePermissionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_runtime_permissions)

        val btnCameraPermission=findViewById<Button>(R.id.btnCameraPermission)
        val btnStoragePermission=findViewById<Button>(R.id.btnStoragePermission)
        btnCameraPermission.setOnClickListener {
            val permission=com.technicalrupu.learningweek1.Helper.Permission(this)
           val code= permission.check(android.Manifest.permission.CAMERA,101)
            if(code==200)
            {
                Toast.makeText(applicationContext,"Camera Permission Granted",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext,"Camera Permission Not Granted",Toast.LENGTH_SHORT).show()
            }
        }
        btnStoragePermission.setOnClickListener {
            val permission=com.technicalrupu.learningweek1.Helper.Permission(this)
            val code= permission.check(android.Manifest.permission.READ_EXTERNAL_STORAGE,105)
            if(code==200)
            {
                Toast.makeText(applicationContext,"Storage Permission Granted",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext,"Storage Permission Not Granted",Toast.LENGTH_SHORT).show()
            }
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        val permission=com.technicalrupu.learningweek1.Helper.Permission(this)
       if(requestCode==101)
       {
           val code= permission.result(101,android.Manifest.permission.CAMERA,requestCode,grantResults)
           if(code==200)
           {
               Toast.makeText(applicationContext,"Camera Permission Granted",Toast.LENGTH_SHORT).show()
           }else{
               Toast.makeText(applicationContext,"Camera Permission Not Granted",Toast.LENGTH_SHORT).show()
           }
       }
        if(requestCode==105)
        {
            val code= permission.result(105,android.Manifest.permission.CAMERA,requestCode,grantResults)
            if(code==200)
            {
                Toast.makeText(applicationContext,"Storage Permission Granted",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext,"Storage Permission Not Granted",Toast.LENGTH_SHORT).show()
            }
        }


    }
}