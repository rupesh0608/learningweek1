package com.technicalrupu.learningweek1.Retrofit

import retrofit2.Call
import retrofit2.http.GET
import java.util.ArrayList
interface myApi {

    @GET("posts")
    fun getModels() : Call<List<Model>>
}