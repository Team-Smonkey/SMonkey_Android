package com.example.smonkey_android.feature.community

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smonkey_android.databinding.CommunityItemBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class CommunityAdapter(
    val data: List<CommunityData.Content.FeedList>
): RecyclerView.Adapter<CommunityAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]

        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: CommunityItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CommunityData.Content.FeedList) {
            binding.title.text = item.title
            binding.content.text = item.content
            binding.heartCount.text = item.likeCount.toString()
            binding.userName.text = item.writer.userName

            binding.executePendingBindings()

            timeAdapter(this, item.createAt)
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CommunityItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }

            private fun timeAdapter(viewHolder: ViewHolder, time: String) {
                val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.KOREA)
                val subTime = dateFormat.parse(time)
                val date = Date(System.currentTimeMillis())
                val currentTime = dateFormat.format(date)
                val getTime = dateFormat.format(subTime)
                val longCurrentTime = dateFormat.parse(currentTime).time
                val longGetTime = dateFormat.parse(getTime).time
                val diff = (longCurrentTime - longGetTime) / 1000
                val dayDiff = (diff / 86400)
                if (dayDiff < 0 || dayDiff >= 31) {
                    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA)
                    viewHolder.binding.later.text = dateFormat.format(subTime)
                } else {
                    if (dayDiff <= 0) {
                        when (diff) {
                            in 0..60 ->
                                viewHolder.binding.later.text = "방금"
                            in 61..120 -> viewHolder.binding.later.text = "1분전"
                            in 121..3600 ->
                                viewHolder.binding.later.text = "${diff / 60}분 전"
                            in 3601..7200 -> viewHolder.binding.later.text = "1시간 전"
                            else -> viewHolder.binding.later.text = "${diff / 3600}시간 전"
                        }
                    } else {
                        when (dayDiff) {
                            1.toLong() -> viewHolder.binding.later.text = "어제"
                            in 2..6 -> viewHolder.binding.later.text = "${dayDiff}일 전"
                            else -> viewHolder.binding.later.text = "${dayDiff / 7}주 전"
                        }
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
