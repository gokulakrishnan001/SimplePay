package com.example.logindb.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.logindb.databinding.FragmentLoginBinding
import com.example.logindb.viewmodel.*

class LoginFragment:Fragment(){
    private lateinit var binding:FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentLoginBinding.inflate(inflater,container,false)

        val factory=UserModelFactory()

        val viewmodel=ViewModelProvider(this)[UserViewModel::class.java]

        binding.view=viewmodel
        binding.lifecycleOwner=this

        viewmodel._navigation1.observe(this.viewLifecycleOwner){
            if (it)
            {
                wallet()
                viewmodel.walletDone()
            }
        }

        viewmodel._navigation3.observe(this.viewLifecycleOwner){
            if (it)
            {
                dashBoard()
                viewmodel.DashBoardDone()
            }
        }
        viewmodel._navigation4.observe(this.viewLifecycleOwner){
            if (it)
            {
                history()
                viewmodel.HistoryDone()
            }
        }

        viewmodel._navigation2.observe(this.viewLifecycleOwner){
            if (it)
            {
                transaction()
                viewmodel.transactionDone()
            }
        }

        return binding.root
    }
    private fun wallet(){
        val action=LoginFragmentDirections.actionLoginFragmentToWalletFragment();
        NavHostFragment.findNavController(this).navigate(action)
    }
    fun transaction(){
        val action=LoginFragmentDirections.actionLoginFragmentToTranscationFragment();
        NavHostFragment.findNavController(this).navigate(action)
    }

    fun dashBoard(){
        val action=LoginFragmentDirections.actionLoginFragmentToDashBoardFragment();
        NavHostFragment.findNavController(this).navigate(action)
    }

    fun history(){
        val action=LoginFragmentDirections.actionLoginFragmentToHistoryFragment()
        NavHostFragment.findNavController(this).navigate(action)
    }

}