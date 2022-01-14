package com.technicalrupu.learningweek1.CustomCP

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

 class EmployerDB(context: Context?):SQLiteOpenHelper(context,"Employer",null,1) {

     override fun onCreate(db: SQLiteDatabase?) {
          db?.execSQL("CREATE TABLE DETAILS(_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT,PHONE TEXT)")
          db?.execSQL("INSERT INTO DETAILS(NAME,PHONE ) VALUES('Rupesh Kumar Deshmukh','7898400139')")

     }

     override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
         TODO("Not yet implemented")
     }

 }