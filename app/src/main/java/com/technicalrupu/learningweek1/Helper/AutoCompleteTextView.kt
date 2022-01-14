package com.technicalrupu.learningweek1.Helper

import android.app.Activity
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.technicalrupu.learningweek1.R
import java.util.*

class AutoCompleteTextView(val ref: Activity) {


    fun create(AutoCompleteTextViewId: Int, dataList: Array<String>):AutoCompleteTextView {
        val autoTextView = ref.findViewById<AutoCompleteTextView>(AutoCompleteTextViewId)
        val adapter = ArrayAdapter(
            ref,
            android.R.layout.simple_list_item_1, dataList
        )
        autoTextView.setAdapter(adapter)
        return autoTextView
    }
}