package com.technicalrupu.learningweek1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.technicalrupu.learningweek1.Helper.Button
import org.w3c.dom.Text
import java.lang.Exception

class ErrorHandlingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error_handling)
        title="Error Handling"

       val edtNum1 =findViewById<EditText>(R.id.edtNum1)
       val edtNum2 =findViewById<EditText>(R.id.edtNum2)

        val btn=Button(this)
       val btnCalculate= btn.create(R.id.btnCalculate)
        btnCalculate.setOnClickListener{
            val txtOutput=findViewById<TextView>(R.id.output)
            try {
                   val num1:Int =edtNum1.text.toString().toInt()
                   val num2:Int =edtNum2.text.toString().toInt()
                val output=num1/num2

                txtOutput.text=output.toString()

            }catch (e:Exception)
            {
                txtOutput.text="error"
                Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()
            }
        }
    }
}