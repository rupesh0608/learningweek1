package com.technicalrupu.learningweek1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import com.technicalrupu.learningweek1.Helper.Checkbox

class CheckboxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox)
        title="Checkbox";
         val checkBox=Checkbox(this)
       val checkbox1= checkBox.create(R.id.checkbox1)
       val checkbox2= checkBox.create(R.id.checkbox2)
        val checkbox3=checkBox.create(R.id.checkbox3)

        val submitBtn=findViewById<Button>(R.id.submitBtn)
        submitBtn.setOnClickListener{
           val outputText= findViewById<TextView>(R.id.output)
           val array= arrayOf(checkbox1,checkbox2,checkbox3)
            outputText.text = checkBox.getValues(array)
        }
    }




}