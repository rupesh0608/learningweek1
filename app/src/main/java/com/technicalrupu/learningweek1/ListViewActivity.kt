package com.technicalrupu.learningweek1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.technicalrupu.learningweek1.Helper.Activity
import com.technicalrupu.learningweek1.Helper.Button
import com.technicalrupu.learningweek1.ListView.CustomListViewActivity
import com.technicalrupu.learningweek1.ListView.NormalListviewActivity

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        title = "List View"
        val btn = Button(this)
        val activity = Activity(this)

        val normalListviewBtn = btn.create(R.id.normalListViewBtn)
        normalListviewBtn.setOnClickListener {
            activity.startActivity(NormalListviewActivity())
        }

        val customListviewBtn = btn.create(R.id.customListViewBtn)
        customListviewBtn.setOnClickListener {
            activity.startActivity(CustomListViewActivity())
        }
    }
}