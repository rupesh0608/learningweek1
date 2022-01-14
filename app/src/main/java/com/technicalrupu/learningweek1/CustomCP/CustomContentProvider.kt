package com.technicalrupu.learningweek1.CustomCP

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri
import android.util.Log
import android.widget.Toast

class CustomContentProvider :ContentProvider(){
     companion object{
         private const val PROVIDER_NAME="com.technicalrupu.learningweek1.CustomCP.CustomContentProvider"
         private const val URL="content://$PROVIDER_NAME/DETAILS"
         val CONTENT_URI: Uri =Uri.parse(URL)

         val _ID="_id"
         val NAME="NAME"
         val PHONE="PHONE"
     }

   lateinit var db:SQLiteDatabase;
    override fun onCreate(): Boolean {
        val database=EmployerDB(context)
        db=database.writableDatabase
       return if(db==null) false else true
    }

    override fun query(
        uri: Uri,
        cols: Array<out String>?,
        condition: String?,
        condition_value: Array<out String>?,
        order: String?
    ): Cursor? {
      return  db.query("DETAILS",cols,condition,condition_value,null,null,order)
    }

    override fun getType(uri: Uri): String? {
        return "vnd.android.cursor.dir/vnd.example.DETAILS"
    }

    override fun insert(uri: Uri, cv: ContentValues?): Uri? {
        db.insert("DETAILS",null,cv)
        context?.contentResolver?.notifyChange(uri,null)
        return uri
    }

    override fun delete(uri: Uri, condition: String?, condition_value: Array<out String>?): Int {
      val count=  db.delete("DETAILS",condition,condition_value)
        context?.contentResolver?.notifyChange(uri,null)
        return count
    }

    override fun update(
        uri: Uri,
        cv: ContentValues?,
        condition: String?,
        condition_value: Array<out String>?
    ): Int {
       val count= db.update("DETAILS",cv,condition,condition_value)
        context?.contentResolver?.notifyChange(uri,null)
        return count
    }
}