package com.technicalrupu.learningweek1.Maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.technicalrupu.learningweek1.Helper.PolylineMap
import com.technicalrupu.learningweek1.R
import com.technicalrupu.learningweek1.databinding.ActivityPolylineMapBinding


class PolylineMapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityPolylineMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPolylineMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
       //creating Polyline
        val polylineObj= PolylineMap(this)
        val polyline=polylineObj.create(googleMap,true)
        polyline.tag="A"
         stylePolyline(polyline)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(-23.684, 133.903), 4f))


        //creating polygon
        val polygon = googleMap.addPolygon(PolygonOptions()
            .clickable(true)
            .add(
                LatLng(-27.457, 153.040),
                LatLng(-33.852, 151.211),
                LatLng(-37.813, 144.962),
                LatLng(-34.928, 138.599)))
        polygon.tag = "alpha"
        stylePolygon(polygon)
    }
}


private fun stylePolygon(polygon: Polygon) {

    val COLOR_WHITE_ARGB = -0x1
    val COLOR_DARK_GREEN_ARGB = -0xc771c4
    val COLOR_LIGHT_GREEN_ARGB = -0x7e387c
    val COLOR_DARK_ORANGE_ARGB = -0xa80e9
    val COLOR_LIGHT_ORANGE_ARGB = -0x657db
    val POLYGON_STROKE_WIDTH_PX = 8
    val PATTERN_DASH_LENGTH_PX = 20

    val DASH: PatternItem = Dash(PATTERN_DASH_LENGTH_PX.toFloat())
    val PATTERN_GAP_LENGTH_PX = 20
    val DOT: PatternItem = Dot()
    val GAP: PatternItem = Gap(PATTERN_GAP_LENGTH_PX.toFloat())
    val PATTERN_POLYGON_ALPHA = listOf(GAP, DASH)

    val PATTERN_POLYGON_BETA = listOf(DOT, GAP, DASH, GAP)

    val type = polygon.tag?.toString() ?: ""
    var pattern: List<PatternItem>? = null
    var strokeColor = COLOR_BLACK_ARGB
    var fillColor = COLOR_WHITE_ARGB
    when (type) {
        "alpha" -> {
            pattern = PATTERN_POLYGON_ALPHA
            strokeColor = COLOR_DARK_GREEN_ARGB
            fillColor = COLOR_LIGHT_GREEN_ARGB
        }
        "beta" -> {
            pattern = PATTERN_POLYGON_BETA
            strokeColor = COLOR_DARK_ORANGE_ARGB
            fillColor = COLOR_LIGHT_ORANGE_ARGB
        }
    }
    polygon.strokePattern = pattern
    polygon.strokeWidth = POLYGON_STROKE_WIDTH_PX.toFloat()
    polygon.strokeColor = strokeColor
    polygon.fillColor = fillColor

}

private val COLOR_BLACK_ARGB = -0x657db
private val POLYLINE_STROKE_WIDTH_PX = 12




private fun stylePolyline(polyline: Polyline) {
    when (polyline.tag?.toString() ?: "") {
        "A" -> {
            polyline.startCap = CustomCap(
                BitmapDescriptorFactory.defaultMarker(), 15f)
        }
        "B" -> {
            polyline.startCap = RoundCap()
        }
    }
    polyline.endCap = RoundCap()
    polyline.width = POLYLINE_STROKE_WIDTH_PX.toFloat()
    polyline.color = COLOR_BLACK_ARGB
    polyline.jointType = JointType.ROUND
}


