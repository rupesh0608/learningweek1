package com.technicalrupu.learningweek1.Helper

import android.app.Activity
import android.widget.RadioButton
import android.widget.RadioGroup

class RadioButton(ref:Activity){
    val ref:Activity=ref

    fun create(id:Int):RadioButton{
       return ref.findViewById<RadioButton>(id)
    }
    fun getValue(RadioGroupId:Int):String{
        val radioGroup=ref.findViewById<RadioGroup>(RadioGroupId)
        val id=radioGroup.checkedRadioButtonId
        return if(ref.findViewById<RadioButton>(id)!=null)
            ref.findViewById<RadioButton>(id).text.toString()
        else "No Output"
    }

}