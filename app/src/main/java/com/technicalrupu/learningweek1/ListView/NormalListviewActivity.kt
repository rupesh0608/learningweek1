package com.technicalrupu.learningweek1.ListView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.technicalrupu.learningweek1.R

class NormalListviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_listview)

        title = " Normal List View"
        val cars= arrayListOf<String>();
        for (i in 1..150) {
            cars.add("item $i")
        }
        val simpleListView=com.technicalrupu.learningweek1.Helper.ListView(this)
        val listItem= simpleListView.simpleListView(R.id.list,cars)
        listItem.setOnItemClickListener{
                parent, view, position, id ->
            Toast.makeText(this,cars[position],Toast.LENGTH_SHORT).show()
        }
    }
}