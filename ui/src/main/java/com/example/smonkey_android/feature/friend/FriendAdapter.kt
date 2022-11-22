package com.example.smonkey_android.feature.friend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smonkey_android.R
import com.example.smonkey_android.databinding.FriendItemBinding

class FriendAdapter(
    val data: List<FriendListData.FriendList>
): RecyclerView.Adapter<FriendAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]

        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: FriendItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: FriendListData.FriendList) {
            binding.namelevel.text = item.userName + "   " + item.level + "LEVEL"
            binding.smonkeynamestep.text = item.smonkeyName + "   " + item.step + "단계"
            binding.progress.progress = item.point
            binding.progress.max = item.nextPoint
            if (item.level < 3) {
                binding.ib.setImageResource(R.drawable.sickmonkey)
            } else if (item.level < 9) {
                binding.ib.setImageResource(R.drawable.tiredsmonkey)
            } else if (item.level < 18) {
                binding.ib.setImageResource(R.drawable.yummymonkey)
            } else if (item.level < 30) {
                binding.ib.setImageResource(R.drawable.happysmonkey)
            }
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = FriendItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}