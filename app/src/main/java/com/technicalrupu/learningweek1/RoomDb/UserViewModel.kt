package com.technicalrupu.learningweek1.RoomDb

import android.util.Log
import androidx.lifecycle.*
import com.technicalrupu.learningweek1.RoomDb.Tables.User
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    val allUsers: LiveData<List<User>> = repository.allUsers.asLiveData()

    fun insert(user: User) = viewModelScope.launch {
        repository.insert(user)
    }
    fun delete() {
        repository.delete()
    }
    fun update(id:Int,name:String,phone:Long) {
        Log.d("rupesh",id.toString())
        repository.update(id,name,phone)
    }
}

class UserViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}