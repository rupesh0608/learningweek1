package com.technicalrupu.learningweek1

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import com.technicalrupu.learningweek1.Helper.Button

class ToastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)
        title="Toast"

        val btn=Button(this)
        val toast=com.technicalrupu.learningweek1.Helper.ToastClass(this)
       val simpleToast= btn.create(R.id.simpleToast)

        simpleToast.setOnClickListener{

            toast.simpleToast("Simple Toast",Toast.LENGTH_SHORT)

        }

       val customToast= btn.create(R.id.customToast)
        customToast.setOnClickListener{
           toast.customToast("Custom Toast")
        }
    }
}