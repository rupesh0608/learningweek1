package com.technicalrupu.learningweek1.RoomDb.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.technicalrupu.learningweek1.RoomDb.Tables.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun getAllUsers(): Flow<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insert(user: User)
    @Query("UPDATE user_table SET name = :name, phone=:phone WHERE id = :id")
     fun update(id:Int,name:String,phone:Long)

    @Query("DELETE FROM user_table")
     fun deleteAll()
}