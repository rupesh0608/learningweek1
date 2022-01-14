package com.technicalrupu.learningweek1.Retrofit

class Model(var userId:Int,var id:Int,var title:String,var body:String) {

    @JvmName("getUserId1")
    fun getUserId(): Int {
        return userId
    }

    @JvmName("getId1")
    fun getId(): Int {
        return id
    }
        @JvmName("getTitle1")
        fun getTitle():String {
        return title
    }

    @JvmName("getBody1")
    fun getBody(): String {
        return body
    }

    @JvmName("setUserId1")
    fun setUserId(userId: Int){
        this.userId=userId
    }


    @JvmName("setId1")
    fun setId(id:Int) {
        this.id=id
    }

    @JvmName("setTitle1")
    fun setTitle(title:String) {
        this.title=title
    }

    @JvmName("setBody1")
    fun setBody(body:String){
        this.body=body
    }

}