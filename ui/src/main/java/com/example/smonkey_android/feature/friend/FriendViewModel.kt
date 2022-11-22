package com.example.smonkey_android.feature.friend

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.domain.usecase.friend.AddFriendUseCase
import com.example.data.domain.usecase.friend.FetchFriendListUseCase
import com.example.data.domain.usecase.friend.ReceiveRequestUseCase
import com.example.data.domain.usecase.friend.RefuseRequestUseCase
import com.example.data.domain.usecase.friend.RequestListUseCase
import com.example.data.domain.usecase.friend.SearchFriendUseCase
import com.example.data.remote.response.friend.FriendListResponse
import com.example.data.remote.response.friend.RequestListResponse
import com.example.smonkey_android.feature.community.CommunityViewModel
import com.example.smonkey_android.util.MutableEventFlow
import com.example.smonkey_android.util.asEventFlow
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import kotlinx.coroutines.launch

class FriendViewModel (
    private val addFriendUseCase: AddFriendUseCase,
    private val fetchFriendListUseCase: FetchFriendListUseCase,
    private val receiveRequestUseCase: ReceiveRequestUseCase,
    private val refuseRequestUseCase: RefuseRequestUseCase,
    private val searchFriendUseCase: SearchFriendUseCase,
    private val requestListUseCase: RequestListUseCase,
) : ViewModel() {

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    fun friendList() {
        fetchFriendListUseCase.execute(
            Unit, object : DisposableSingleObserver<FriendListResponse>() {
                override fun onSuccess(t: FriendListResponse) {
                    event(Event.FetchFriendList(t))
                }

                override fun onError(e: Throwable) {

                }
            }, AndroidSchedulers.mainThread()
        )
    }

    fun requestList() {
        requestListUseCase.execute(
            Unit, object : DisposableSingleObserver<RequestListResponse>() {
                override fun onSuccess(t: RequestListResponse) {
                    event(Event.FetchRequestList(t))
                }

                override fun onError(e: Throwable) {
                    event(Event.ErrorMessage("시도 중 오류가 발생하였습니다."))
                }
            }, AndroidSchedulers.mainThread()
        )
    }

    fun receive(friendId: Long) {
        receiveRequestUseCase.execute(
            friendId, object: DisposableSingleObserver<Completable>(){
                override fun onSuccess(t: Completable) {
                    event(Event.ReceiveRequest)
                }

                override fun onError(e: Throwable) {
                    event(Event.ErrorMessage(""))
                }
            }, AndroidSchedulers.mainThread()
        )
    }

    fun refuse(friendId: Long) {
        refuseRequestUseCase.execute(
            friendId, object: DisposableSingleObserver<Completable>(){
                override fun onSuccess(t: Completable) {
                    event(Event.RefuseRequest)
                }

                override fun onError(e: Throwable) {
                    event(Event.ErrorMessage(""))
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
        object ReceiveRequest : Event()
        object RefuseRequest : Event()
        data class FetchFriendList(val friendListResponse: FriendListResponse) : Event()
        data class FetchRequestList(val requestListResponse: RequestListResponse) : Event()
    }
}