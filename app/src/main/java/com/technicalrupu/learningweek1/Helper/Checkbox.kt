package com.technicalrupu.learningweek1.Helper

import android.app.Activity
import android.content.Context
import android.widget.CheckBox

class Checkbox(context:Activity){

    private var ref:Activity=context
    fun create(id:Int):CheckBox{
      return ref.findViewById<CheckBox>(id)
    }
   fun getValues(array:Array<CheckBox>):String{
        var tempText="";
        for(checkbox in array)
        {
            if(checkbox.isChecked)
            {
                tempText=tempText+"\n"+checkbox.text
            }
        }
        if(tempText == "")
        {
            return "No output";
        }else{
            return tempText;
        }
    }
}