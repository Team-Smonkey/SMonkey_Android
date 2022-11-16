package com.example.smonkey_android.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.domain.usecase.user.SignInUseCase
import com.example.data.remote.request.user.LoginRequest
import com.example.data.remote.response.LoginResponse
import com.example.smonkey_android.util.MutableEventFlow
import com.example.smonkey_android.util.asEventFlow
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import kotlinx.coroutines.launch

class LoginViewModel(
    private val signInUseCase: SignInUseCase
): ViewModel() {

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    fun signIn(accountId: String, password: String,) {
        signInUseCase.execute(
            LoginRequest(accountId, password), object : DisposableSingleObserver<LoginResponse>() {
                override fun onSuccess(t: LoginResponse) {
                    event(Event.Success(t))
                }

                override fun onError(e: Throwable) {
                    event(Event.ErrorMessage("로그인에 실패하였습니다."))
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
        data class Success(val loginResponse: LoginResponse) : Event()
    }
}