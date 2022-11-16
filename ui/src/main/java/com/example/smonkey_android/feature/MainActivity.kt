package com.example.smonkey_android.feature

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.preference.PreferenceManager
import com.example.data.domain.token.ACCESS_TOKEN
import com.example.data.domain.token.Storage
import com.example.data.domain.token.StorageImpl
import com.example.smonkey_android.R
import com.example.smonkey_android.base.BaseActivity
import com.example.smonkey_android.databinding.ActivityMainBinding
import com.example.smonkey_android.feature.home.HomeActivity
import com.example.smonkey_android.feature.login.LoginActivity
import com.example.smonkey_android.feature.register.RegisterActivity

class MainActivity() : BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val storage: Storage = StorageImpl(sharedPreferences)

        ACCESS_TOKEN = storage.fetchToken()

        if (storage.fetchMasterYi()) {
            val intent = Intent(this, HomeActivity::class.java)
            finishAffinity()
            startActivity(intent)
        } else if (!storage.fetchMasterYi()) {
            Log.d("dbgusaud", storage.fetchMasterYi().toString())
        }
    }

    override fun initView() {
        binding.btLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}