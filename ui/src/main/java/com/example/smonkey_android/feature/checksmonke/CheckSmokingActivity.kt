package com.example.smonkey_android.feature.checksmonke

import android.os.Bundle
import com.example.smonkey_android.R
import com.example.smonkey_android.base.BaseActivity
import com.example.smonkey_android.databinding.ActivityCheckSmokingBinding

class CheckSmokingActivity : BaseActivity<ActivityCheckSmokingBinding>(
    R.layout.activity_check_smoking
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initView() {
        binding.btComplete.setOnClickListener {
            finish()
        }
    }
}