package com.example.smonkey_android.feature.setting

import android.content.Intent
import com.example.smonkey_android.R
import com.example.smonkey_android.base.BaseFragment
import com.example.smonkey_android.databinding.FragmentSettingBinding
import com.example.smonkey_android.feature.editauth.ChangeIdActivity
import com.example.smonkey_android.feature.editauth.ChangePwActivity
import com.example.smonkey_android.feature.health.HealthActivity
import com.example.smonkey_android.feature.monkeycolor.MonkeyColorActivity
import com.example.smonkey_android.feature.mypage.MyPageActivity

class SettingFragment : BaseFragment<FragmentSettingBinding>(
    R.layout.fragment_setting
) {
    override fun initView() {

        binding.moveMyProfile.setOnClickListener {
            val intent = Intent(activity, MyPageActivity::class.java)
            startActivity(intent)
        }

        binding.myProfile.setOnClickListener {
            val intent = Intent(activity, MyPageActivity::class.java)
            startActivity(intent)
        }

        binding.updatesmoke.setOnClickListener {
            val intent = Intent(activity, HealthActivity::class.java)
            startActivity(intent)
        }

        binding.moveupdatesmoke.setOnClickListener {
            val intent = Intent(activity, HealthActivity::class.java)
            startActivity(intent)
        }

        binding.updatesmonkey.setOnClickListener {
            val intent = Intent(activity, MonkeyColorActivity::class.java)
            startActivity(intent)
        }

        binding.moveupdateSmonkey.setOnClickListener {
            val intent = Intent(activity, MonkeyColorActivity::class.java)
            startActivity(intent)
        }

        binding.idedit.setOnClickListener {
            val intent = Intent(activity, ChangeIdActivity::class.java)
            startActivity(intent)
        }

        binding.moveeditid.setOnClickListener {
            val intent = Intent(activity, ChangeIdActivity::class.java)
            startActivity(intent)
        }

        binding.pwedit.setOnClickListener {
            val intent = Intent(activity, ChangePwActivity::class.java)
            startActivity(intent)
        }

        binding.moveeditpw.setOnClickListener {
            val intent = Intent(activity, ChangePwActivity::class.java)
            startActivity(intent)
        }

        binding.logout.setOnClickListener {
            TODO("LogOut")
        }
    }
}
