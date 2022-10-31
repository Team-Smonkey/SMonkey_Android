package com.example.smonkey_android.feature.login

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import com.example.smonkey_android.R
import com.example.smonkey_android.base.BaseActivity
import com.example.smonkey_android.databinding.ActivityLoginBinding
import com.example.smonkey_android.feature.home.HomeActivity
import com.example.smonkey_android.feature.register.RegisterActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(
    R.layout.activity_login
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initView() {
        binding.register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btLogin.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            finishAffinity()
            startActivity(intent)
        }

        binding.constraint.setOnClickListener {
            hideKeyboard()
        }
    }

    @SuppressLint("ServiceCast")
    private fun hideKeyboard() {
        val inputManager: InputMethodManager =
            this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(
            this.currentFocus!!.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    }
}
