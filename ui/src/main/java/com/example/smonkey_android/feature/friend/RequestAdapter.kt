package com.example.smonkey_android.feature.friend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smonkey_android.databinding.RequestFriendItemBinding

class RequestAdapter(
    val data: List<RequestData>
): RecyclerView.Adapter<RequestAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]

        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: RequestFriendItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RequestData) {

            binding.userName.text = item.userName
            binding.content.text = item.smonkeyName + "  " + item.level + "LV"

            binding.executePendingBindings()

            binding.bt.setOnClickListener {

            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RequestFriendItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}