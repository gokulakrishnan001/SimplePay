package com.example.logindb.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.logindb.database.TransactionRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import androidx.lifecycle.*
import com.example.logindb.database.Details
import com.example.logindb.database.DetailsRepository
import com.example.logindb.database.Wallet
import kotlinx.coroutines.flow.Flow

class TransactionModel(private val walletRepository: TransactionRepository,
                       private val detailsRepository: DetailsRepository
    ):ViewModel() {

    val amount= MutableLiveData<String>()

    val toastMessge=MutableLiveData<String>()

    val navigation=MutableLiveData<Boolean>()

    val sender=MutableLiveData<String>()

    val receiver=MutableLiveData<String>()

    val transferAmount=MutableLiveData<String>()

    val _navigation: LiveData<Boolean>
        get() = navigation

    private val data: Flow<List<Wallet?>> = walletRepository.getUserDetails()

    fun addWallet(){

        if(amount.value!=null)
        {
         insertAmount(Wallet(id = 0,amount= amount.value!!,"0","0"))
            navigation.value=true
            Log.i("data",amount.value!!)
        }
        else{
            toastMessge.value="Enter a Amount"
            navigation.value=false
        }
    }

    val cashBack=MutableLiveData<String>()

    private val tAmount:Int?
        get() = transferAmount.value?.toInt()

    private val getcashBack=MutableLiveData<Boolean>()

     val toastMessage1=MutableLiveData<Boolean>()

    private val back=MutableLiveData<Boolean>()

    private val finalAmount=MutableLiveData<Int>()

    fun send()
    {
        if(sender.value!=null && receiver.value!=null && transferAmount.value!=null)
        {
            if(transferAmount.value?.toInt()!! <= 1000){
                cashBack.value= tAmount?.toInt()?.times(0.05).toString()
                toastMessage1.value=true
                 finalAmount.value=amount.value?.toInt()?.minus(cashBack.value!!.toInt())
                insertAmount(
                    Wallet(
                    amount = finalAmount.value.toString(),
                    senderAmount = sender.value!!,
                    recevierAmount = receiver.value!!
                )
                )
            }
           else if(transferAmount.value?.toInt()!! >= 1000){
                cashBack.value= tAmount?.toInt()?.times(0.02).toString()
                toastMessage1.value=true
                finalAmount.value=amount.value?.toInt()?.minus(cashBack.value!!.toInt())
                insertAmount(Wallet(
                    amount = finalAmount.value.toString(),
                    senderAmount = sender.value!!,
                    recevierAmount = receiver.value!!
                ))
            }else{
                toastMessage1.value=false
            }
        }else{
            back.value=false
        }
    }

    private fun insertAmount(wallet:Wallet):Job=viewModelScope.launch{
        walletRepository.insert(wallet)
    }

    private fun updateAmount(wallet: Wallet):Job=
        viewModelScope.launch {
            walletRepository.update(wallet)
        }


    val _data= liveData {
        data.collect{
            emit(it)

        }
    }

    val userData:Flow<List<Details?>> = detailsRepository.getAllData()





    val _data1= liveData {
        userData.collect{
            emit(it)
        }
    }

}



