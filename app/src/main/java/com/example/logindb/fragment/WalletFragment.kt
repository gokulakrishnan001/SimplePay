package com.example.logindb.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.logindb.database.DetailsRepository
import com.example.logindb.database.LoginDatabase
import com.example.logindb.database.WalletDatabase
import com.example.logindb.database.TransactionRepository
import com.example.logindb.databinding.IndexPageBinding
import com.example.logindb.viewmodel.TransactionModel
import com.example.logindb.viewmodel.TransactionModelFactory

class WalletFragment : Fragment(){
 private lateinit var binding:IndexPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= IndexPageBinding.inflate(inflater,container,false)
        val dao= WalletDatabase.getInstance(this.activity!!).walletDetailsDao()

        val repository= TransactionRepository(dao)
        val dao1= LoginDatabase.getInstance(this.activity!!).loginDetailDao()

        val repository1= DetailsRepository(dao1)
        val factory= TransactionModelFactory(repository,repository1)
        val viewModel= ViewModelProvider(this,factory)[TransactionModel::class.java]

        binding.viewModel=viewModel
        binding.lifecycleOwner=this

        viewModel._navigation.observe(this.viewLifecycleOwner){
            if (it)
            {
               backMenu()
            }else{
                Toast.makeText(this.context,viewModel.toastMessge.value,Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }
    private fun backMenu(){
        val action=WalletFragmentDirections.actionWalletFragmentToLoginFragment()
        NavHostFragment.findNavController(this).navigate(action)
    }

}