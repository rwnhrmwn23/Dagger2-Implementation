package com.onedev.dicoding.dagger2implementation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.onedev.dicoding.dagger2implementation.databinding.ListItemBinding
import com.onedev.dicoding.dagger2implementation.model.RecyclerData

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var listData: List<RecyclerData>? = null

    fun setData(listData: List<RecyclerData>) {
        this.listData = listData
    }

    inner class MyViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: RecyclerData) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.owner?.avatar_url)
                    .into(imageViewAvatar)
                tvName.text = data.name
                tvDescription.text = data.description
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listData!![position])
    }

    override fun getItemCount(): Int {
        return if (listData == null) 0 else listData!!.size
    }
}