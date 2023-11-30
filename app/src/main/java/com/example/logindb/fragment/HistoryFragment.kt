package com.example.logindb.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.logindb.Adapter.HistroyAdapter
import com.example.logindb.Adapter.WalletAdapter
import com.example.logindb.database.DetailsRepository
import com.example.logindb.database.LoginDatabase
import com.example.logindb.database.TransactionRepository
import com.example.logindb.database.WalletDatabase
import com.example.logindb.databinding.TransactionHistoryBinding
import com.example.logindb.viewmodel.TransactionModel
import com.example.logindb.viewmodel.TransactionModelFactory

class HistoryFragment:Fragment() {

    private lateinit var binding:TransactionHistoryBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=TransactionHistoryBinding.inflate(inflater,container,false)
        val dao= WalletDatabase.getInstance(this.activity!!).walletDetailsDao()
        val repository= TransactionRepository(dao)
        val dao1= LoginDatabase.getInstance(this.activity!!).loginDetailDao()

        val repository1= DetailsRepository(dao1)
        val factory= TransactionModelFactory(repository,repository1)

        val viewmodel= ViewModelProvider(this,factory)[TransactionModel::class.java]

        binding.lifecycleOwner=this




        viewmodel._data.observe(this.viewLifecycleOwner){
            recycleView()
            binding.recycle1.adapter= HistroyAdapter(it)
        }

        return binding.root
    }
    private fun recycleView(){
        binding.recycle1.hasFixedSize()
        binding.recycle1.layoutManager= LinearLayoutManager(this.context)
    }
}