package com.technicalrupu.learningweek1.RoomDb

import com.technicalrupu.learningweek1.RoomDb.Dao.UserDao
import com.technicalrupu.learningweek1.RoomDb.Tables.User
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {

    val allUsers: Flow<List<User>> = userDao.getAllUsers()

     fun insert(user: User) {
        userDao.insert(user)
    }
    fun update(id: Int, name: String, phone: Long) {
        userDao.update(id,name,phone)
    }
    fun delete() {
        userDao.deleteAll()
    }
}