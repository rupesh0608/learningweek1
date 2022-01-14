package com.technicalrupu.learningweek1.RecyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.technicalrupu.learningweek1.ListView.Car
import com.technicalrupu.learningweek1.R
import com.technicalrupu.learningweek1.RecyclerViewAdapter

class GridRecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_recycler_view)
        title="Grid RecyclerView"
        val data = ArrayList<Car>()

        for (i in 1..150) {
            val car = Car()
            car.setTitle("item " + i)
            data.add(car)
        }
        val adapter = RecyclerViewAdapter(this, data)

        val recyclerview = com.technicalrupu.learningweek1.Helper.RecyclerView(this)
        recyclerview.gridRecyclerView(R.id.recyclerview, adapter,2)
    }
}