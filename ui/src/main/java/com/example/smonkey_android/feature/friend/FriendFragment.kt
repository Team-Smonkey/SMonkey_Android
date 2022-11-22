package com.example.smonkey_android.feature.friend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.data.domain.enums.CategoryType
import com.example.smonkey_android.R
import com.example.smonkey_android.base.BaseFragment
import com.example.smonkey_android.databinding.FragmentFriendBinding
import com.example.smonkey_android.feature.community.CommunityAdapter
import com.example.smonkey_android.feature.community.CommunityData
import com.example.smonkey_android.feature.community.CommunityViewModel
import com.example.smonkey_android.util.repeatOnStarted
import org.koin.androidx.viewmodel.ext.android.viewModel

class FriendFragment : BaseFragment<FragmentFriendBinding>(
    R.layout.fragment_friend
) {
    private val vm: FriendViewModel by viewModel()

    private var rvFriendData = ArrayList<FriendListData.FriendList>()
    private var rvRequestData = ArrayList<RequestData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vm.friendList()
        repeatOnStarted {
            vm.eventFlow.collect { event -> handleEvent(event) }
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun handleEvent(event: FriendViewModel.Event) {
        when(event) {
            is FriendViewModel.Event.FetchFriendList -> {
                setFriend(event.friendListResponse.content.friendList.map { it.toRv() })
                binding.rv.adapter?.notifyDataSetChanged()
            }
            is FriendViewModel.Event.FetchRequestList -> {
                setRequest(event.requestListResponse.content.friendList.map { it.toRv() })
                binding.rv.adapter?.notifyDataSetChanged()
            }
            is FriendViewModel.Event.ErrorMessage -> {
                showShortToast(event.message)
                binding.rv.adapter?.notifyDataSetChanged()
            }
        }
    }

    override fun initView() {

        setAdapter()

        setFrag(0)

        binding.btFriendList.setOnClickListener{
            setFrag(0)
            rvFriendData.clear()
            setAdapter()
            vm.friendList()
        }

        binding.btRequestFreiend.setOnClickListener {
            setFrag(2)
            rvRequestData.clear()
            setAdapter2()
            vm.requestList()
        }
    }

    private fun setAdapter() {
        val mAdapter = FriendAdapter(rvFriendData)

        binding.rv.run {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = mAdapter
        }
        binding.rv.adapter?.notifyDataSetChanged()
    }

    private fun setAdapter2() {
        val mAdapter = RequestAdapter(rvRequestData, vm)

        binding.rv.run {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = mAdapter
        }
    }

    private fun setFrag(fragNum: Int) {
        when (fragNum) {
            0 -> {
                binding.friendlist.visibility = View.VISIBLE
                binding.requestFreiend.visibility = View.INVISIBLE
            }
            2 -> {
                binding.friendlist.visibility = View.INVISIBLE
                binding.requestFreiend.visibility = View.VISIBLE
            }
        }
    }
    private fun setFriend(data: List<FriendListData.FriendList>) {
        for (element in data) {
            rvFriendData.add(element)
        }
        binding.rv.adapter?.notifyDataSetChanged()
    }

    private fun setRequest(data: List<RequestData>) {
        for (element in data) {
            rvRequestData.add(element)
        }
        binding.rv.adapter?.notifyDataSetChanged()
    }
}