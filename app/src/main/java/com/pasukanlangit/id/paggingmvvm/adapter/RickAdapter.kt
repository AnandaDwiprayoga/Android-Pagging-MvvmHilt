package com.pasukanlangit.id.paggingmvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.pasukanlangit.id.paggingmvvm.databinding.ItemRickBinding
import com.pasukanlangit.id.paggingmvvm.models.ResultsItem

class RickAdapter:PagingDataAdapter<ResultsItem, RickAdapter.MyViewHolder>(diffCalback) {

    inner class MyViewHolder(val binding: ItemRickBinding): RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCalback = object : DiffUtil.ItemCallback<ResultsItem>(){
            override fun areItemsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
                 return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //this method getItem() is from PagingDataAdapter
        val currentItem = getItem(position)

        holder.binding.apply {
            textView.text = "${currentItem?.name}"

            //coil = coroutine image loader
            imageView.load(currentItem?.image){
                crossfade(true)
                crossfade(1000)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       return MyViewHolder(ItemRickBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

}