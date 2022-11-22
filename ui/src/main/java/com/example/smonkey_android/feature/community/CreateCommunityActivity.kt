package com.example.smonkey_android.feature.community

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import com.example.smonkey_android.R
import com.example.smonkey_android.base.BaseActivity
import com.example.smonkey_android.databinding.ActivityCreateCommunityBinding

class CreateCommunityActivity : BaseActivity<ActivityCreateCommunityBinding>(
    R.layout.activity_create_community
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initView() {
        binding.category.setOnClickListener {
            val cates = resources.getStringArray(R.array.Community)

            val builder = AlertDialog.Builder(this@CreateCommunityActivity)

            builder.setTitle("카테고리")

            builder.setItems(cates,
                DialogInterface.OnClickListener { dialog, which -> binding.category.text = (cates[which]) })
            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()
        }
    }
}