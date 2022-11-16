package com.example.smonkey_android.feature.promise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smonkey_android.R
import com.example.smonkey_android.base.BaseActivity
import com.example.smonkey_android.databinding.ActivityPromiseBinding
import com.example.smonkey_android.feature.health.HealthActivity

class PromiseActivity() : BaseActivity<ActivityPromiseBinding>(
    R.layout.activity_promise
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun initView() {
        binding.btCheck.setOnClickListener {
            val intent = Intent(this, HealthActivity::class.java)
            startActivity(intent)
        }
    }
}