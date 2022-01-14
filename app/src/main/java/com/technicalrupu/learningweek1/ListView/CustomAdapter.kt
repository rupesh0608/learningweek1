package com.technicalrupu.learningweek1.ListView

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.technicalrupu.learningweek1.R

class CustomAdapter(val context:Activity, private val arrayList: ArrayList<Car>):ArrayAdapter<Car>(context, R.layout.view1,arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflator:LayoutInflater= LayoutInflater.from(context)
        val view:View=inflator.inflate(R.layout.view1,null)

        val title=view.findViewById<TextView>(R.id.text)
        title.text=arrayList[position].title

        return view
    }
}