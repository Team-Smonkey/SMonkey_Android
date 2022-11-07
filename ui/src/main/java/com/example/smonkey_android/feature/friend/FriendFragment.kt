package com.example.smonkey_android.feature.friend

import android.view.View
import com.example.smonkey_android.R
import com.example.smonkey_android.base.BaseFragment
import com.example.smonkey_android.databinding.FragmentFriendBinding

class FriendFragment : BaseFragment<FragmentFriendBinding>(
    R.layout.fragment_friend
) {
    override fun initView() {

        setFrag(0)

        binding.btFriendList.setOnClickListener{
            setFrag(0)
        }

        binding.btFindFriend.setOnClickListener {
            setFrag(1)
        }

        binding.btRequestFreiend.setOnClickListener {
            setFrag(2)
        }

        binding.btCheer.setOnClickListener {
            setFrag(3)
        }
    }

    private fun setFrag(fragNum: Int) {
        when (fragNum) {
            0 -> {
                binding.friendlist.visibility = View.VISIBLE
                binding.findFriend.visibility = View.INVISIBLE
                binding.requestFreiend.visibility = View.INVISIBLE
                binding.cheer.visibility = View.INVISIBLE
            }
            1 -> {
                binding.friendlist.visibility = View.INVISIBLE
                binding.findFriend.visibility = View.VISIBLE
                binding.requestFreiend.visibility = View.INVISIBLE
                binding.cheer.visibility = View.INVISIBLE
            }
            2 -> {
                binding.friendlist.visibility = View.INVISIBLE
                binding.findFriend.visibility = View.INVISIBLE
                binding.requestFreiend.visibility = View.VISIBLE
                binding.cheer.visibility = View.INVISIBLE
            }
            3 -> {
                binding.friendlist.visibility = View.INVISIBLE
                binding.findFriend.visibility = View.INVISIBLE
                binding.requestFreiend.visibility = View.INVISIBLE
                binding.cheer.visibility = View.VISIBLE
            }
        }
    }
}