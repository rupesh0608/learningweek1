package com.technicalrupu.learningweek1.RoomDb.Tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")

class User(
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "phone")
    var phone: Long
){
    @PrimaryKey(autoGenerate = true) var id: Int=0
}