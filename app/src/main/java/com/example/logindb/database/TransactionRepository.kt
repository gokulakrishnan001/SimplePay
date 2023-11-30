package com.example.logindb.database

import kotlinx.coroutines.flow.Flow

class TransactionRepository(private val dao: TransactionDao) {

    suspend fun insert(user:Wallet){
        return dao.insertAmount(user)
    }

     fun getUserDetails(): Flow<List<Wallet?>> {
        return dao.getAllData()
    }

    suspend fun update(data:Wallet){
        return dao.updateAmount(data)
    }
}