package com.technicalrupu.learningweek1.RoomDb

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class UserApplication:Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())

    private val database by lazy { UserDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { UserRepository(database.userDao()) }
}