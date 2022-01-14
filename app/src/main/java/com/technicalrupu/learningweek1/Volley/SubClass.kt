package com.technicalrupu.learningweek1.Volley

import android.app.Activity
import android.os.AsyncTask
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class SubClass(var ref: Activity) : AsyncTask<Void, Void, String>() {
    override fun doInBackground(vararg params: Void?): String {
return ""
    }

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
    }

    override fun onProgressUpdate(vararg values: Void?) {
        super.onProgressUpdate(*values)
    }

    override fun onCancelled(result: String?) {
        super.onCancelled(result)
    }

    override fun onCancelled() {
        super.onCancelled()
    }
}