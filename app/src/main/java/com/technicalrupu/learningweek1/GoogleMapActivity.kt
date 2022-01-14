package com.technicalrupu.learningweek1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.technicalrupu.learningweek1.Maps.CurrentLocationActivity
import com.technicalrupu.learningweek1.Maps.MarkerMapActivity
import com.technicalrupu.learningweek1.Maps.PolylineMapActivity

class GoogleMapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_map)
        title="Google Map"


        val btnMarker=findViewById<Button>(R.id.btnMarker)
        btnMarker.setOnClickListener {
            startActivity(Intent(this, MarkerMapActivity::class.java))
        }
        val btnPlyLines=findViewById<Button>(R.id.btnPolyLinesAndPolyGone)
        btnPlyLines.setOnClickListener {
            startActivity(Intent(this, PolylineMapActivity::class.java))
        }
        val btnCurrentLocation=findViewById<Button>(R.id.btnCurrentLocation)
        btnCurrentLocation.setOnClickListener {
            startActivity(Intent(this, CurrentLocationActivity::class.java))
        }



    }
}