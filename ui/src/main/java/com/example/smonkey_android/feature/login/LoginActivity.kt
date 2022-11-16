package com.example.smonkey_android.feature.login

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.preference.PreferenceManager
import com.example.data.domain.token.Storage
import com.example.data.domain.token.StorageImpl
import com.example.smonkey_android.R
import com.example.smonkey_android.base.BaseActivity
import com.example.smonkey_android.databinding.ActivityLoginBinding
import com.example.smonkey_android.feature.promise.PromiseActivity
import com.example.smonkey_android.feature.register.RegisterActivity
import com.example.smonkey_android.util.repeatOnStarted
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity<ActivityLoginBinding>(
    R.layout.activity_login,
) {

    private val vm: LoginViewModel by viewModel()

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        repeatOnStarted {
            vm.eventFlow.collect { event -> handleEvent(event) }
        }
    }

    override fun initView() {
        binding.register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btLogin.setOnClickListener {
            val id: String = binding.etId.text.toString()
            val pw: String = binding.etPassword.text.toString()

            vm.signIn(id, pw)
        }

        binding.constraint.setOnClickListener {
            hideKeyboard()
        }
    }

    private fun handleEvent(event: LoginViewModel.Event) {
        when(event) {
            is LoginViewModel.Event.ErrorMessage -> {
                showShortToast(event.message)
            }
            is LoginViewModel.Event.Success -> {
                val sharedPreferences: SharedPreferences =
                    PreferenceManager.getDefaultSharedPreferences(this)
                val storage: Storage = StorageImpl(sharedPreferences)
                val intent = Intent(this, PromiseActivity::class.java)

                storage.saveMasterYi()
                storage.saveToken("")
                startActivity(intent)
            }
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
