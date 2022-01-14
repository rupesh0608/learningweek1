package com.technicalrupu.learningweek1.RecyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.technicalrupu.learningweek1.ListView.Car
import com.technicalrupu.learningweek1.R
import com.technicalrupu.learningweek1.RecyclerViewAdapter

class LinearRecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_recycler_view)
        title = "Linear RecycleView"
        val data = ArrayList<Car>()

        for (i in 1..20) {
            val car = Car()
            car.setTitle("item " + i)
            data.add(car)
        }
        val adapter = RecyclerViewAdapter(this,data)

        val recyclerview = com.technicalrupu.learningweek1.Helper.RecyclerView(this)
        recyclerview.linearRecyclerView(R.id.recyclerview, adapter)
    }
}