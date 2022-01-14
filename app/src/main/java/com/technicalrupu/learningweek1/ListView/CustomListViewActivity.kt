package com.technicalrupu.learningweek1.ListView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.technicalrupu.learningweek1.R

class CustomListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list_view)
        title="Custom List View"

        val carList=ArrayList<Car>()
        for (i in 1..150) {
            val car = Car()
            car.setTitle("item " + i)
            carList.add(car)
        }

       val listView=com.technicalrupu.learningweek1.Helper.ListView(this)
       val item= listView.customListView(R.id.list,carList)

        item.setOnItemClickListener(){adapterView, view, position, id ->

            Toast.makeText(this, carList.get(position).getTitle(), Toast.LENGTH_SHORT).show()
        }
    }
}