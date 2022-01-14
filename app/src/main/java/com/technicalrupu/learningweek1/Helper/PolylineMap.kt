package com.technicalrupu.learningweek1.Helper

import android.app.Activity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions

class PolylineMap(var ref: Activity) {

    fun create(googleMap: GoogleMap, clickable: Boolean): Polyline {
        return googleMap.addPolyline(
            PolylineOptions()
                .clickable(clickable)
                .add(
                    LatLng(-35.016, 143.321),
                    LatLng(-34.747, 145.592),
                    LatLng(-34.364, 147.891),
                    LatLng(-33.501, 150.217),
                    LatLng(-32.306, 149.248),
                    LatLng(-32.491, 147.309)
                )
        )
    }
}