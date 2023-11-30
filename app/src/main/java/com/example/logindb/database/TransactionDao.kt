package com.example.logindb.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {

    @Insert
    suspend fun insertAmount(wallet: Wallet)

    @Query("SELECT * FROM Wallet")
    fun getAllData(): Flow<List<Wallet?>>

    @Update
    suspend fun updateAmount(wallet: Wallet)


}