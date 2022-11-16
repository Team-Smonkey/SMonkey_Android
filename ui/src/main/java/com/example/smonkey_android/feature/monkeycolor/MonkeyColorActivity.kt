package com.example.smonkey_android.feature.monkeycolor

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColor
import com.example.smonkey_android.R
import com.example.smonkey_android.base.BaseActivity
import com.example.smonkey_android.databinding.ActivityMonkeyColorBinding
import com.example.smonkey_android.feature.MainActivity

@Suppress("DEPRECATION")
class MonkeyColorActivity : BaseActivity<ActivityMonkeyColorBinding>(
    R.layout.activity_monkey_color,
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initView() {

        binding.firstoneSeaGreen.setOnClickListener {
            binding.colorView.setBackgroundColor(resources.getColor(R.color.SeaGreen))
        }

        binding.firsttwoAppleGreen.setOnClickListener {
            binding.colorView.setBackgroundColor(resources.getColor(R.color.AppleGreen))
        }

        binding.firstthreeYellowGreen.setOnClickListener {
            binding.colorView.setBackgroundColor(resources.getColor(R.color.YellowGreen))
        }

        binding.firstfouryellow.setOnClickListener {
            binding.colorView.setBackgroundColor(resources.getColor(R.color.LightYellow))
        }

        binding.firstfiveorange.setOnClickListener {
            binding.colorView.setBackgroundColor(resources.getColor(R.color.LightOrange))
        }

        binding.firstsixred.setOnClickListener {
            binding.colorView.setBackgroundColor(resources.getColor(R.color.LightRed))
        }

        binding.secondoneCerise.setOnClickListener {
            binding.colorView.setBackgroundColor(resources.getColor(R.color.Cerise))
        }

        binding.secondtwoMagenta.setOnClickListener {
            binding.colorView.setBackgroundColor(resources.getColor(R.color.Magenta))
        }

        binding.secondthreeLightCoral.setOnClickListener {
            binding.colorView.setBackgroundColor(resources.getColor(R.color.LightCoral))
        }

        binding.secondfourBisqure.setOnClickListener {
            binding.colorView.setBackgroundColor(resources.getColor(R.color.Bisqure))
        }

        binding.secondfiveBiossom.setOnClickListener {
            binding.colorView.setBackgroundColor(resources.getColor(R.color.Blossom))
        }

        binding.secondsixpink.setOnClickListener {
            binding.colorView.setBackgroundColor(resources.getColor(R.color.Pink))
        }

        binding.thirdonedarkpink.setOnClickListener {
            binding.colorView.setBackgroundColor(resources.getColor(R.color.DarkPink))
        }

        binding.thirdtwoPlum.setOnClickListener {
            binding.colorView.setBackgroundColor(resources.getColor(R.color.Plum))
        }

        binding.thirdthreeSkyBlue.setOnClickListener {
            binding.colorView.setBackgroundColor(resources.getColor(R.color.SkyBlue))
        }

        binding.thirdfourLightAqua.setOnClickListener {
            binding.colorView.setBackgroundColor(resources.getColor(R.color.LightAqua))
        }

        binding.thirdfiveLightBlue.setOnClickListener {
            binding.colorView.setBackgroundColor(resources.getColor(R.color.LightBlue))
        }

        binding.thirdsixViolet.setOnClickListener {
            binding.colorView.setBackgroundColor(resources.getColor(R.color.Violet))
        }

        binding.fouroneOrchid.setOnClickListener {
            binding.colorView.setBackgroundColor(resources.getColor(R.color.Orchid))
        }

        binding.fourtwoPurple.setOnClickListener {
            binding.colorView.setBackgroundColor(resources.getColor(R.color.Purple))
        }

        binding.fourthreenavy.setOnClickListener {
            binding.colorView.setBackgroundColor(resources.getColor(R.color.Navy))
        }

        binding.btComplete.setOnClickListener {
            finish()
        }
    }
}
