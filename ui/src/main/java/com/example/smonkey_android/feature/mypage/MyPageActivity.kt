package com.example.smonkey_android.feature.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.smonkey_android.R
import com.example.smonkey_android.base.BaseActivity
import com.example.smonkey_android.databinding.ActivityMyPageBinding

class MyPageActivity : BaseActivity<ActivityMyPageBinding>(
    R.layout.activity_my_page
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
    }
}
