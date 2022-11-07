package com.example.smonkey_android.feature.community

import android.view.View
import androidx.core.view.isInvisible
import com.example.smonkey_android.R
import com.example.smonkey_android.base.BaseFragment
import com.example.smonkey_android.databinding.FragmentCommunityBinding

class CommunityFragment : BaseFragment<FragmentCommunityBinding>(
    R.layout.fragment_community
) {
    override fun initView() {

        setFrag(0)

        binding.btAll.setOnClickListener {
            setFrag(0)
        }

        binding.btInformation.setOnClickListener {
            setFrag(1)
        }

        binding.btThink.setOnClickListener {
            setFrag(2)
        }

        binding.btQuestion.setOnClickListener {
            setFrag(3)
        }
        binding.btMind.setOnClickListener {
            setFrag(4)
        }
    }

    private fun setFrag(fragNum: Int) {
        when (fragNum) {
            0 -> {
                binding.allview.visibility = View.VISIBLE
                binding.informationview.visibility = View.INVISIBLE
                binding.questionview.visibility = View.INVISIBLE
                binding.thinkview.visibility = View.INVISIBLE
                binding.mindview.visibility = View.INVISIBLE
            }
            1 -> {
                binding.allview.visibility = View.INVISIBLE
                binding.informationview.visibility = View.VISIBLE
                binding.questionview.visibility = View.INVISIBLE
                binding.thinkview.visibility = View.INVISIBLE
                binding.mindview.visibility = View.INVISIBLE
            }
            2 -> {
                binding.allview.visibility = View.INVISIBLE
                binding.informationview.visibility = View.INVISIBLE
                binding.questionview.visibility = View.INVISIBLE
                binding.thinkview.visibility = View.VISIBLE
                binding.mindview.visibility = View.INVISIBLE
            }
            3 -> {
                binding.allview.visibility = View.INVISIBLE
                binding.informationview.visibility = View.INVISIBLE
                binding.questionview.visibility = View.VISIBLE
                binding.thinkview.visibility = View.INVISIBLE
                binding.mindview.visibility = View.INVISIBLE
            }
            4 -> {
                binding.allview.visibility = View.INVISIBLE
                binding.informationview.visibility = View.INVISIBLE
                binding.questionview.visibility = View.INVISIBLE
                binding.thinkview.visibility = View.INVISIBLE
                binding.mindview.visibility = View.VISIBLE
            }
        }
    }
}