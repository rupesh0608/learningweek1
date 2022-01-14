package com.technicalrupu.learningweek1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.technicalrupu.learningweek1.Helper.MusicPlayer

class BackgroundServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background_service)
        val btnPlay=findViewById<Button>(R.id.btnPlay)
        btnPlay.setOnClickListener {
            startService(Intent(this, MusicPlayer::class.java))
        }

        val btnStop=findViewById<Button>(R.id.btnStop)
        btnStop.setOnClickListener {
            stopService(Intent(this, MusicPlayer::class.java))
        }

    }
}