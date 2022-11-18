package com.example.smonkey_android.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.domain.usecase.smonkey.AlterSMonkeyColorUseCase
import com.example.data.domain.usecase.smonkey.MakeSMonkeyUseCase
import com.example.data.domain.usecase.smonkey.SearchSMonkeyUseCase
import com.example.data.remote.request.user.LoginRequest
import com.example.data.remote.response.LoginResponse
import com.example.data.remote.response.smonkey.SearchSMonkeyResponse
import com.example.smonkey_android.util.MutableEventFlow
import com.example.smonkey_android.util.asEventFlow
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import kotlinx.coroutines.launch

class SMonkeyViewModel(
    private val alterSMonkeyColorUseCase: AlterSMonkeyColorUseCase,
    private val makeSMonkeyUseCase: MakeSMonkeyUseCase,
    private val searchSMonkeyUseCase: SearchSMonkeyUseCase,
): ViewModel() {

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    fun fetchSMonkey() {
        searchSMonkeyUseCase.execute(
            Unit, object : DisposableSingleObserver<SearchSMonkeyResponse>() {
                override fun onSuccess(t: SearchSMonkeyResponse) {
                    event(Event.Success(t))
                }

                override fun onError(e: Throwable) {
                    event(Event.ErrorMessage("스몽키에 문제가 발생하였습니다."))
                }
            }, AndroidSchedulers.mainThread()
        )
    }

    private fun event(event: Event) {
        viewModelScope.launch {
            _eventFlow.emit(event)
        }
    }

    sealed class Event {
        data class ErrorMessage(val message: String) : Event()
        data class Success(val searchSMonkeyResponse: SearchSMonkeyResponse) : Event()
    }
}