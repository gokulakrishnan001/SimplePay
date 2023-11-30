package com.example.logindb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.logindb.database.DetailsRepository
import com.example.logindb.database.TransactionRepository
import java.lang.IllegalArgumentException

class TransactionModelFactory(private val repository: TransactionRepository,private val detailsRepository: DetailsRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TransactionModel::class.java)){
            return TransactionModel(repository,detailsRepository) as T
        }
        throw IllegalArgumentException("")
    }
}