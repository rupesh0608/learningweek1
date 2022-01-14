package com.technicalrupu.learningweek1.Helper

import android.app.Activity
import android.content.Intent
import android.widget.TextView
import com.technicalrupu.learningweek1.R
import com.technicalrupu.learningweek1.StartActivityForResultFolder.StartActivityForResult2

class Activity(context: Activity) {
    private var ref:Activity = context

    fun startActivity(NewActivity: Activity) {
        val intent = Intent(ref, NewActivity::class.java)
        ref.startActivity(intent)
    }
    fun passMsg( NewActivity: Activity, id: String, msg: String) {
        val intent = Intent(ref, NewActivity::class.java)
        intent.putExtra(id, msg)
        ref.startActivity(intent)
    }
    fun withAnimation(NewActivity: Activity ,anim1Id:Int,anim2Id:Int) {
        val intent = Intent(ref, NewActivity::class.java)
        ref.startActivity(intent)
       ref.overridePendingTransition(anim1Id, anim2Id)
    }
    fun setActivityForResult(NewActivity: Activity,RequestCode:Int) {
        val intent = Intent(ref, NewActivity::class.java)
        ref.startActivityForResult(intent, RequestCode)
    }
    fun receiveActivityForResult(RequestCode:Int,ResultCode:Int,data:Intent,key:String): String? {
        if (RequestCode == 2) {
            if (ResultCode == Activity.RESULT_OK) {
                return  data!!.getStringExtra(key)

            }
        }
        return null
    }
    fun sendActivityForResultSuccessfully(key:String,msg:String) {
        val intent = Intent()
        intent.putExtra(key, msg)
        ref.setResult(Activity.RESULT_OK, intent)
        ref.finish()
    }
    fun sendActivityForResultCanceled() {
        val intent = Intent()
        ref.setResult(Activity.RESULT_CANCELED, intent)
        ref.finish()
    }
}