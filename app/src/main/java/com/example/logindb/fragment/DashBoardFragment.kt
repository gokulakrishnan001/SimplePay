package com.example.logindb.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.logindb.Adapter.WalletAdapter
import com.example.logindb.database.Details
import com.example.logindb.database.DetailsRepository
import com.example.logindb.database.LoginDatabase
import com.example.logindb.database.WalletDatabase
import com.example.logindb.database.TransactionRepository
import com.example.logindb.database.Wallet
import com.example.logindb.databinding.DashboardPageBinding
import com.example.logindb.viewmodel.TransactionModel
import com.example.logindb.viewmodel.TransactionModelFactory

class DashBoardFragment: Fragment() {
    private lateinit var binding:DashboardPageBinding
    private var adapter1:List<Wallet?> = listOf()
     private var adapter2:List<Details?> = listOf()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= DashboardPageBinding.inflate(inflater,container,false)

        val dao= WalletDatabase.getInstance(this.activity!!).walletDetailsDao()
        val repository= TransactionRepository(dao)
        val dao1=LoginDatabase.getInstance(this.activity!!).loginDetailDao()

        val repository1=DetailsRepository(dao1)
        val factory= TransactionModelFactory(repository,repository1)

        val viewmodel=ViewModelProvider(this,factory)[TransactionModel::class.java]

        binding.lifecycleOwner=this.viewLifecycleOwner




        viewmodel._data1.observe(this.viewLifecycleOwner){
            recycleView()
            binding.recycle1.adapter=WalletAdapter(it)
        }




        return binding.root
    }
    private fun recycleView(){
        binding.recycle1.hasFixedSize()
        binding.recycle1.layoutManager=LinearLayoutManager(this.context)
    }

}

/*
val dao=LoginDatabase.getInstance(this.activity!!).loginDetailDao()
        val repository=DetailsRepository(dao)
        val factory=UserModelFactory(repository)

        val viewmodel=ViewModelProvider(this,factory)[UserViewModel::class.java]

        binding.lifecycleOwner=this.viewLifecycleOwner
        viewmodel.data.observe(this.viewLifecycleOwner){
            recycleView()
            binding.recycle1.adapter=ListAdapter(it)
        }
 */