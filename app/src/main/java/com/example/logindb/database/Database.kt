package com.example.logindb.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Details::class], version = 1, exportSchema = false)
abstract class LoginDatabase:RoomDatabase() {
    abstract fun loginDetailDao(): LoginDao
    companion object {
        @Volatile
        var INSTANCE: LoginDatabase? = null
        fun getInstance(context: Context): LoginDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        LoginDatabase::class.java,
                        "LoginDb"
                    ).fallbackToDestructiveMigration()
                        .build()
                }
                return instance
            }
        }
    }
}

@Database(entities = [Wallet::class], version = 2, exportSchema = false)
abstract class WalletDatabase:RoomDatabase() {
    abstract fun walletDetailsDao(): TransactionDao
    companion object {
        @Volatile
        var INSTANCE: WalletDatabase? = null
        fun getInstance(context: Context): WalletDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        WalletDatabase::class.java,
                        "WalletDb"
                    ).fallbackToDestructiveMigration()
                        .build()
                }
                return instance
            }
        }
    }
}
/**
@Database(entities = [Transaction::class], version = 1, exportSchema = false)
abstract class TransactionDatabase:RoomDatabase() {
    abstract fun loginDetailDao()
    companion object {
        @Volatile
        var INSTANCE: TransactionDatabase? = null
        fun getInstance(context: Context): TransactionDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TransactionDatabase::class.java,
                        "TransactionDb"
                    ).fallbackToDestructiveMigration()
                        .build()
                }
                return instance
            }
        }
    }
}
*/

