package com.technicalrupu.learningweek1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.technicalrupu.learningweek1.Retrofit.Model
import com.technicalrupu.learningweek1.Retrofit.myApi
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitActivity : AppCompatActivity() {

    var url:String="https://jsonplaceholder.typicode.com/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
        title="Retrofit"

        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api: myApi = retrofit.create(myApi::class.java)
        api.getModels().enqueue(object : Callback<List<Model>> {
            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {
               val data=response.body()
                if (data != null) {
                    val textView=findViewById<TextView>(R.id.txtView)
                    for (item:Model in data )
                    {
                        textView.append("SNO :"+item.getId()+"\n\nTitle :"+item.getTitle()+"\n\nBody :"+item. getBody()+"\n\n\n")
                    }
                }
            }
            override fun onFailure(call: Call<List<Model>>, t: Throwable) {

            }
        })
    }
}