package com.example.smonkey_android.feature.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.data.remote.response.smonkey.SearchSMonkeyResponse
import com.example.smonkey_android.R
import com.example.smonkey_android.base.BaseActivity
import com.example.smonkey_android.databinding.ActivityMyPageBinding
import com.example.smonkey_android.feature.SMonkeyViewModel
import com.example.smonkey_android.util.repeatOnStarted
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyPageActivity : BaseActivity<ActivityMyPageBinding>(
    R.layout.activity_my_page
) {

    private val vm: SMonkeyViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm.fetchSMonkey()
        repeatOnStarted {
            vm.eventFlow.collect { event -> handleEvent(event) }
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
        if (searchSMonkeyResponse.content.level < 3) {
            binding.view.setImageResource(R.drawable.sickmonkey)
        } else if (searchSMonkeyResponse.content.level < 9) {
            binding.view.setImageResource(R.drawable.tiredsmonkey)
        } else if (searchSMonkeyResponse.content.level < 18) {
            binding.view.setImageResource(R.drawable.yummymonkey)
        } else if (searchSMonkeyResponse.content.level < 30) {
            binding.view.setImageResource(R.drawable.happysmonkey)
        }
        binding.tvSmonkeyname.text = searchSMonkeyResponse.content.sMonkeyName
        binding.tvName.text = searchSMonkeyResponse.content.userName
        binding.pb.progress = searchSMonkeyResponse.content.point
        binding.pb.max = searchSMonkeyResponse.content.nextPoint
        binding.tvLevel.text = "${searchSMonkeyResponse.content.level}레벨"
    }

    override fun initView() {

        binding.post.setOnClickListener {
            binding.view3.visibility = View.VISIBLE
            binding.view4.visibility = View.INVISIBLE
        }

        binding.comment.setOnClickListener {
            binding.view3.visibility = View.INVISIBLE
            binding.view4.visibility = View.VISIBLE
        }

        binding.btBack.setOnClickListener {
            finish()
        }
    }
}
