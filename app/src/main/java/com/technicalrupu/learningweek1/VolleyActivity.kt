package com.technicalrupu.learningweek1

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest

import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
import com.technicalrupu.learningweek1.Retrofit.Model
import org.json.JSONObject
import java.lang.Exception


class VolleyActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volley)
        title = "Volley"
        try {

            val url = "https://jsonplaceholder.typicode.com/posts"
            val requestQueue = Volley.newRequestQueue(this)
            val jsonArrayRequest = JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                { response ->
                     val data=ArrayList<Model>()
                    for(i in 0 until response.length())
                    {
                        val details: JSONObject = response.getJSONObject(i)
                        val userId:Int=details.getString("userId").toInt()
                        val id:Int=details.getString("id").toInt()
                        val title:String=details.getString("title")
                        val body:String=details.getString("body")
                        data.add(Model(userId,id,title,body))
                    }
                   feedData(data)
                },
                { response ->

                })
            requestQueue.add(jsonArrayRequest)
        } catch (e: Exception) {
            Log.d("rupesh", "onCreate: " + e.message)
            Toast.makeText(this, e.message.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun feedData(data: ArrayList<Model>) {
        val txtView=findViewById<TextView>(R.id.txtView)
        for (item in data) {
            txtView.append("Sno :"+item.getId()+"\nTitle : "+item.getTitle()+"\nBody :"+item.getBody()+"\n\n\n")
        }
    }
}