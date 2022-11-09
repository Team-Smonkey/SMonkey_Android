package com.example.smonkey_android.feature.health

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import com.example.smonkey_android.R
import com.example.smonkey_android.base.BaseActivity
import com.example.smonkey_android.databinding.ActivityHealthBinding
import java.util.Calendar

class HealthActivity : BaseActivity<ActivityHealthBinding>(
    R.layout.activity_health
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initView() {
        binding.view3.setOnClickListener {
            val c = Calendar.getInstance()
            val nYear = c[Calendar.YEAR]
            val nMon = c[Calendar.MONTH]
            val nDay = c[Calendar.DAY_OF_MONTH]

            val mDateSetListener =
                OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    binding.tvSmokingDay.text = year.toString() + "년 " + (monthOfYear + 1).toString() + "월 " + dayOfMonth.toString() + "일"
                }

            val oDialog = DatePickerDialog(
                this@HealthActivity,
                android.R.style.Theme_DeviceDefault_Light_Dialog,
                mDateSetListener, nYear, nMon, nDay
            )
            oDialog.show()
        }

        binding.view4.setOnClickListener {
            val c = Calendar.getInstance()
            val nYear = c[Calendar.YEAR]
            val nMon = c[Calendar.MONTH]
            val nDay = c[Calendar.DAY_OF_MONTH]

            val mDateSetListener =
                OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    binding.tvNonSmokingTime.text = year.toString() + "년 " + (monthOfYear + 1).toString() + "월 " + dayOfMonth.toString() + "일"
                }

            val oDialog = DatePickerDialog(
                this@HealthActivity,
                android.R.style.Theme_DeviceDefault_Light_Dialog,
                mDateSetListener, nYear, nMon, nDay
            )
            oDialog.show()
        }
    }
}