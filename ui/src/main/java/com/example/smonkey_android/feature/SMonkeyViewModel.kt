package com.example.smonkey_android.feature

import androidx.lifecycle.ViewModel
import com.example.data.domain.usecase.smonkey.AlterSMonkeyColorUseCase
import com.example.data.domain.usecase.smonkey.MakeSMonkeyUseCase
import com.example.data.domain.usecase.smonkey.SearchSMonkeyUseCase

class SMonkeyViewModel(
    private val alterSMonkeyColorUseCase: AlterSMonkeyColorUseCase,
    private val makeSMonkeyUseCase: MakeSMonkeyUseCase,
    private val searchSMonkeyUseCase: SearchSMonkeyUseCase,
): ViewModel() {

}