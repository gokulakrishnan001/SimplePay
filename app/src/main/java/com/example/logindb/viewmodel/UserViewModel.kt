package com.example.logindb.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.logindb.database.Details
import com.example.logindb.database.DetailsRepository
import kotlinx.coroutines.flow.Flow


class UserViewModel : ViewModel(){


    private val Walletnavigation = MutableLiveData<Boolean>()

    private val Transcationnavigation = MutableLiveData<Boolean>()

    private val DashBoardnavigation = MutableLiveData<Boolean>()

    private val Historynavigation = MutableLiveData<Boolean>()


    val _navigation1: LiveData<Boolean>
        get() = Walletnavigation

    val _navigation2:LiveData<Boolean>
        get() = Transcationnavigation

    val _navigation3: LiveData<Boolean>
        get() = DashBoardnavigation

    val _navigation4: LiveData<Boolean>
        get() = Historynavigation
 fun wallet(){
     Walletnavigation.value=true;
 }

    fun dashboard(){
        DashBoardnavigation.value=true
    }

    fun history(){
        Historynavigation.value=true
    }

 fun transcation(){
     Transcationnavigation.value=true;
 }

    fun walletDone(){
        Transcationnavigation.value=false
        DashBoardnavigation.value=false
        Historynavigation.value=false
    }

    fun transactionDone(){
        Walletnavigation.value=false
        DashBoardnavigation.value=false
        Historynavigation.value=false
    }

    fun DashBoardDone(){
        Transcationnavigation.value=false
            Walletnavigation.value=false
        Historynavigation.value=false
    }

    fun HistoryDone(){
        Transcationnavigation.value=false
        DashBoardnavigation.value=false
            Walletnavigation.value=false
    }


}











