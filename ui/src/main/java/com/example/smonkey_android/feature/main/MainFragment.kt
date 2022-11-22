package com.example.smonkey_android.feature.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import com.example.data.domain.usecase.smonkey.SearchSMonkeyUseCase
import com.example.data.remote.response.LoginResponse
import com.example.data.remote.response.smonkey.SearchSMonkeyResponse
import com.example.smonkey_android.R
import com.example.smonkey_android.base.BaseFragment
import com.example.smonkey_android.databinding.FragmentHomeBinding
import com.example.smonkey_android.feature.SMonkeyViewModel
import com.example.smonkey_android.feature.checksmonke.CheckSmokingActivity
import com.example.smonkey_android.feature.friend.FriendViewModel
import com.example.smonkey_android.feature.friend.toRv
import com.example.smonkey_android.util.repeatOnStarted
import dagger.hilt.android.qualifiers.ApplicationContext
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentHomeBinding>(
    R.layout.fragment_home
) {
    private val vm: SMonkeyViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vm.fetchSMonkey()
        repeatOnStarted {
            vm.eventFlow.collect { event -> handleEvent(event) }
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun initView() {
        binding.checkSmoke.setOnClickListener {
            val intent = Intent(activity, CheckSmokingActivity::class.java)
            startActivity(intent)
        }
    }

    private fun handleEvent(event: SMonkeyViewModel.Event) {
        when(event) {
            is SMonkeyViewModel.Event.ErrorMessage -> {
                showShortToast(event.message)
            }
            is SMonkeyViewModel.Event.Success -> {
                setValue(event.searchSMonkeyResponse)
            }
        }
    }

    fun setValue(searchSMonkeyResponse: SearchSMonkeyResponse) {
        binding.tvSmonkeyname.text = searchSMonkeyResponse.content.sMonkeyName
        binding.smonkeylevel.text = "Lv_" + searchSMonkeyResponse.content.level.toString()
        binding.progress.progress = searchSMonkeyResponse.content.point
        binding.progress.max = searchSMonkeyResponse.content.nextPoint
        binding.a.text = searchSMonkeyResponse.content.point.toString() + "/" + searchSMonkeyResponse.content.nextPoint
        binding.tvMainTitle.text = searchSMonkeyResponse.content.userName

        if (searchSMonkeyResponse.content.level < 3) {
            binding.smonkey.setImageResource(R.drawable.sickmonkey)
        } else if (searchSMonkeyResponse.content.level < 9) {
            binding.smonkey.setImageResource(R.drawable.tiredsmonkey)
        } else if (searchSMonkeyResponse.content.level < 18) {
            binding.smonkey.setImageResource(R.drawable.yummymonkey)
        } else if (searchSMonkeyResponse.content.level < 30) {
            binding.smonkey.setImageResource(R.drawable.happysmonkey)
        }
    }
}
