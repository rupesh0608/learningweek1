package com.technicalrupu.learningweek1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technicalrupu.learningweek1.Helper.Activity
import com.technicalrupu.learningweek1.Helper.Button
import com.technicalrupu.learningweek1.ListView.Car
import com.technicalrupu.learningweek1.RecyclerView.GridRecyclerViewActivity
import com.technicalrupu.learningweek1.RecyclerView.LinearRecyclerViewActivity

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        title = "Recycler view"

        val btn=Button(this)
        val activity=Activity(this)
        val linearRecyclerView= btn.create(R.id.btnLinearRecyclerView)
        linearRecyclerView.setOnClickListener{
            activity.startActivity(LinearRecyclerViewActivity())
        }
        val gridRecyclerView= btn.create(R.id.btnGridRecyclerView)
        gridRecyclerView.setOnClickListener{
            activity.startActivity(GridRecyclerViewActivity())
        }


    }
}