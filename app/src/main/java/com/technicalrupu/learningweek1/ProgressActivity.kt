package com.technicalrupu.learningweek1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class ProgressActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)
        title = "Progress View"

        val progressBar1 = findViewById<ProgressBar>(R.id.progress_Bar1)
        val progressBar2 = findViewById<ProgressBar>(R.id.pBar2)


        val txtView1 = findViewById<TextView>(R.id.text_view1)
        val txtView2 = findViewById<TextView>(R.id.text_view2)


        val btn = findViewById<Button>(R.id.show_button)
        val handler = Handler()

        btn.setOnClickListener {

            progressBar1.visibility = View.VISIBLE
            progressBar2.visibility = View.VISIBLE

            var i = progressBar1.progress

            Thread(Runnable {

                while (i < 100) {
                    i += 1
                    // Update the progress bar and display the current value
                    handler.post(Runnable {
                        progressBar1.progress = i
                        progressBar2.progress=i
                        // setting current progress to the textview
                        txtView1!!.text = i.toString() + "/" + progressBar1.max
                        txtView2!!.text = i.toString() + "/" + progressBar2.max
                    })
                    try {
                        Thread.sleep(100)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
                progressBar1.visibility = View.INVISIBLE
                progressBar2.visibility = View.INVISIBLE

            }).start()
        }
    }
}