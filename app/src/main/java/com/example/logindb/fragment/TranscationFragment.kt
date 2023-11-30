package com.example.logindb.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.logindb.database.DetailsRepository
import com.example.logindb.database.LoginDatabase
import com.example.logindb.database.WalletDatabase
import com.example.logindb.database.TransactionRepository
import com.example.logindb.databinding.TranscationPageBinding
import com.example.logindb.viewmodel.TransactionModel
import com.example.logindb.viewmodel.TransactionModelFactory

class TranscationFragment:Fragment() {

    private lateinit var binding:TranscationPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=TranscationPageBinding.inflate(inflater,container,false)
        val dao= WalletDatabase.getInstance(this.activity!!).walletDetailsDao()
        val repository= TransactionRepository(dao)

        val dao1= LoginDatabase.getInstance(this.activity!!).loginDetailDao()
        val repository1= DetailsRepository(dao1)
        val factory= TransactionModelFactory(repository,repository1)
        val viewModel= ViewModelProvider(this,factory)[TransactionModel::class.java]

        binding.view=viewModel
        binding.lifecycleOwner=this


        viewModel.toastMessage1.observe(this.viewLifecycleOwner){
            if(it){
                Toast.makeText(this.context,"CashBack Amount=${viewModel.cashBack.value}",Toast.LENGTH_LONG).show()
            }
        }



        return binding.root
    }
}