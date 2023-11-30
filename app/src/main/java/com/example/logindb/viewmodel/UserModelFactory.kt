package com.example.logindb.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.logindb.database.DetailsRepository

@Suppress("UNCHECKED_CAST")
class UserModelFactory():ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UserViewModel::class.java)){
            return UserViewModel() as T
        }
        throw IllegalArgumentException(" ")
    }
}