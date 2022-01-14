package com.technicalrupu.learningweek1.Helper

import android.app.Activity
import android.widget.Adapter
import android.widget.AdapterView
import androidx.constraintlayout.helper.widget.Carousel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.technicalrupu.learningweek1.R
import com.technicalrupu.learningweek1.RecyclerViewAdapter

class RecyclerView(ref: Activity) {
    var ref: Activity = ref
    fun linearRecyclerView(RecyclerViewId: Int, adapter: RecyclerViewAdapter) {
        val recyclerview =
            ref.findViewById<androidx.recyclerview.widget.RecyclerView>(RecyclerViewId)
        recyclerview.layoutManager = LinearLayoutManager(ref)
        recyclerview.adapter = adapter
    }

    fun gridRecyclerView(RecyclerViewId: Int, adapter: RecyclerViewAdapter,spanCount:Int) {
        val recyclerview =
            ref.findViewById<androidx.recyclerview.widget.RecyclerView>(RecyclerViewId)
        recyclerview.layoutManager = GridLayoutManager(ref, spanCount)
        recyclerview.adapter = adapter
    }
}