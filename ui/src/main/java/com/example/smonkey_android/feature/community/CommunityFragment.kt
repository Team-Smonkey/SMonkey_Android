package com.example.smonkey_android.feature.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.data.domain.enums.CategoryType
import com.example.smonkey_android.R
import com.example.smonkey_android.base.BaseFragment
import com.example.smonkey_android.databinding.FragmentCommunityBinding
import com.example.smonkey_android.util.repeatOnStarted
import org.koin.androidx.viewmodel.ext.android.viewModel

class CommunityFragment : BaseFragment<FragmentCommunityBinding>(
    R.layout.fragment_community
) {
    private val vm: CommunityViewModel by viewModel()

    private var rvCommunityData = ArrayList<CommunityData.Content.FeedList>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        vm.fetchCommunity(CategoryType.ALL)
        repeatOnStarted {
            vm.eventFlow.collect { event -> handleEvent(event) }
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun initView() {

        setAdapter()

        setFrag(0)

        binding.btAll.setOnClickListener {
            setFrag(0)
            vm.fetchCommunity(CategoryType.ALL)
        }

        binding.btInformation.setOnClickListener {
            setFrag(1)
            vm.fetchCommunity(CategoryType.TIP)
        }

        binding.btThink.setOnClickListener {
            setFrag(2)
            vm.fetchCommunity(CategoryType.WORRY)
        }

        binding.btQuestion.setOnClickListener {
            setFrag(3)
            vm.fetchCommunity(CategoryType.QUESTION)
        }
        binding.btMind.setOnClickListener {
            setFrag(4)
            vm.fetchCommunity(CategoryType.RESOLUTION)
        }
    }

    private fun setAdapter() {
        val mAdapter = CommunityAdapter(rvCommunityData)

        binding.rv.run {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = mAdapter
        }
    }

    private fun handleEvent(event: CommunityViewModel.Event) =
        when(event) {
            is CommunityViewModel.Event.FetchCommunity -> {
                setCommunity(event.fetchCommunityListResponse.content.feedList.map { it.toRv() })
            }

            is CommunityViewModel.Event.ErrorMessage -> {
                showShortToast(event.message)
            }
        }

    private fun setFrag(fragNum: Int) {
        when (fragNum) {
            0 -> {
                binding.allview.visibility = View.VISIBLE
                binding.informationview.visibility = View.INVISIBLE
                binding.questionview.visibility = View.INVISIBLE
                binding.thinkview.visibility = View.INVISIBLE
                binding.mindview.visibility = View.INVISIBLE

            }
            1 -> {
                binding.allview.visibility = View.INVISIBLE
                binding.informationview.visibility = View.VISIBLE
                binding.questionview.visibility = View.INVISIBLE
                binding.thinkview.visibility = View.INVISIBLE
                binding.mindview.visibility = View.INVISIBLE

            }
            2 -> {
                binding.allview.visibility = View.INVISIBLE
                binding.informationview.visibility = View.INVISIBLE
                binding.questionview.visibility = View.INVISIBLE
                binding.thinkview.visibility = View.VISIBLE
                binding.mindview.visibility = View.INVISIBLE

            }
            3 -> {
                binding.allview.visibility = View.INVISIBLE
                binding.informationview.visibility = View.INVISIBLE
                binding.questionview.visibility = View.VISIBLE
                binding.thinkview.visibility = View.INVISIBLE
                binding.mindview.visibility = View.INVISIBLE

            }
            4 -> {
                binding.allview.visibility = View.INVISIBLE
                binding.informationview.visibility = View.INVISIBLE
                binding.questionview.visibility = View.INVISIBLE
                binding.thinkview.visibility = View.INVISIBLE
                binding.mindview.visibility = View.VISIBLE
            }
        }
    }

    private fun setCommunity(data: List<CommunityData.Content.FeedList>) {
        for (element in data) {
        rvCommunityData.add(element)
    }
        binding.rv.adapter?.notifyDataSetChanged()
    }
}