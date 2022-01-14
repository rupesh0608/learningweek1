package com.technicalrupu.learningweek1.Helper

import android.app.Activity
import android.widget.ArrayAdapter
import android.widget.ListView
import com.technicalrupu.learningweek1.ListView.Car
import com.technicalrupu.learningweek1.ListView.CustomAdapter

class ListView(ref:Activity) {
    val ref:Activity=ref

   fun simpleListView(id: Int, list: ArrayList<String>):ListView
    {
        val mListView = ref.findViewById<ListView>(id)
        val arrayAdapter: ArrayAdapter<*> = ArrayAdapter(
            ref,
            android.R.layout.simple_list_item_1, list
        )
        mListView.adapter = arrayAdapter
        return mListView
    }
    fun customListView(id:Int, list: ArrayList<Car>):ListView
    {
        val listView=ref.findViewById<ListView>(id)
        val customAdapter = CustomAdapter(ref,list)
        listView.adapter = customAdapter
        return listView
    }
}