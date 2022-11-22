package com.example.smonkey_android.feature.friend

import android.system.Os.remove
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.smonkey_android.databinding.FragmentFriendBinding
import com.example.smonkey_android.databinding.RequestFriendItemBinding

class RequestAdapter(
    val data: List<RequestData>,
    vm: FriendViewModel,
): RecyclerView.Adapter<RequestAdapter.ViewHolder>() {

    private val viewModel: FriendViewModel = vm

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]

        holder.bind(item, viewModel, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: RequestFriendItemBinding, val binding2: FragmentFriendBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RequestData, vm: FriendViewModel, position: Int) {

            binding.userName.text = item.userName
            binding.content.text = item.smonkeyName + "  " + item.level + "LV"

            binding.executePendingBindings()

            binding.btReceive.setOnClickListener {
                vm.receive(item.friendId)
                binding2.rv.adapter?.notifyDataSetChanged()
            }

            binding.btCancel.setOnClickListener {
                vm.refuse(item.friendId)
                binding2.rv.adapter?.notifyDataSetChanged()
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RequestFriendItemBinding.inflate(layoutInflater, parent, false)
                val binding2 = FragmentFriendBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding, binding2)
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}