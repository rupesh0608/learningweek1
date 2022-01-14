package com.technicalrupu.learningweek1.Helper

import android.app.Activity
import android.widget.Button

class Button(val ref:Activity) {

    fun create(id:Int):Button{
      return  ref.findViewById<Button>(id)
    }
}