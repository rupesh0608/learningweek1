package com.technicalrupu.learningweek1.ListView

class Car() {
    lateinit var title:String;


    @JvmName("getTitle1")
    fun getTitle() :String{
        return title
    }
    @JvmName("setTitle1")
    fun setTitle(title:String){
        this.title=title
    }
}
