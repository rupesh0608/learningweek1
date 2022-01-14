package com.technicalrupu.learningweek1.ContactActivity

class ContactDetails(val id:Int,val name:String,val phoneNumber:String) {


    @JvmName("getName1")
    fun getName():String{
        return name
    }
    @JvmName("getName2")
    fun getPhoneNumber():String{
        return phoneNumber
    }
    @JvmName("getName3")
    fun getId():Int{
        return id
    }

}