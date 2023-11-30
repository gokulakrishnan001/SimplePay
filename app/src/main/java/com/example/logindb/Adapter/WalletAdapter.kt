package com.example.logindb.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.logindb.database.Details
import com.example.logindb.database.Wallet
import com.example.logindb.databinding.ListViewBinding

class WalletAdapter(
     private val user:List<Details?>
    ):RecyclerView.Adapter<WalletAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding:ListViewBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val view=LayoutInflater.from(parent.context)
        val binding=ListViewBinding.inflate(view,parent,false)
        return MyViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            txt1.text="User Name:"+user[position]!!.name
            txt2.text="Mobile Number:"+user[position]!!.phone
            txt3.text="Email"+user[position]!!.email


        }
    }

    override fun getItemCount(): Int {
        return 1
    }
}