package com.technicalrupu.learningweek1.Helper

import android.app.Activity
import android.app.ProgressDialog.show
import android.view.Gravity
import android.view.Gravity.apply
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.core.view.GravityCompat.apply

import android.view.LayoutInflater
import android.view.View


class ToastClass(val ref:Activity) {

    fun simpleToast(msg:String,duration:Int){
        Toast.makeText(ref.applicationContext,msg,duration).show()
    }

    fun customToast(message: String)
    {
        val toast = Toast(ref.applicationContext)
        val view: View = LayoutInflater.from(ref).inflate(com.technicalrupu.learningweek1.R.layout.custom_toast, null)
        view.findViewById<TextView>(com.technicalrupu.learningweek1.R.id.toast_text).text = message
        toast.setView(view)
        toast.setGravity(Gravity.BOTTOM or Gravity.CENTER, 0, 50)
        toast.duration = Toast.LENGTH_LONG
        toast.show()
    }
}