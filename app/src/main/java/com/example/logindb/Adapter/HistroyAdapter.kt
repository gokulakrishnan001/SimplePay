package com.example.logindb.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.logindb.database.Wallet
import com.example.logindb.databinding.ListViewBinding

class HistroyAdapter(private val details:List<Wallet?>):RecyclerView.Adapter<HistroyAdapter.MyViewHolder>() {


    inner class MyViewHolder(val binding: ListViewBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context)
        val binding= ListViewBinding.inflate(view,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistroyAdapter.MyViewHolder, position: Int) {
        holder.binding.apply {
            txt1.text="Transaction no: "+details[position]!!.id
            txt2.text="Total Amount :"+details[position]!!.amount
            txt3.text="Receiver Mobile:"+details[position]!!.recevierAmount
            txt4.text="Sender Mobile:"+details[position]!!.senderAmount
        }
    }



    override fun getItemCount(): Int {
        return details.size
    }
}