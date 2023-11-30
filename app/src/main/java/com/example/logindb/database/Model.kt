package com.example.logindb.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="Login_Details")
data class Details(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="user_id")
    val id:Int=0,
@ColumnInfo(name="user_name")
val name:String,
@ColumnInfo(name="user_email")
val email:String,
@ColumnInfo(name="user_phoneNo")
val phone:String,
@ColumnInfo(name="user_password")
val password:String,
)

@Entity(tableName = "Wallet")
data class Wallet(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("wallet_id")
    val id:Int=0,
    @ColumnInfo(name = "user_amount")
    val amount:String,
    @ColumnInfo("sender_amount")
val senderAmount:String,
@ColumnInfo("receiver_amount")
val recevierAmount:String
)

@Entity(tableName = "Transaction")
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("transaction_id")
    val id:Int=0,

)
