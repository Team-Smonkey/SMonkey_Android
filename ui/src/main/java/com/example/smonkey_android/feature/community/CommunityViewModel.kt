package com.example.smonkey_android.feature.community

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.domain.enums.CategoryType
import com.example.data.domain.usecase.community.CreateCommunityUseCase
import com.example.data.domain.usecase.community.DeleteCommunityUseCase
import com.example.data.domain.usecase.community.FetchCommunityUseCase
import com.example.data.domain.usecase.community.UpdateCommunityUseCae
import com.example.data.remote.response.community.FetchCommunityResponse
import com.example.smonkey_android.util.MutableEventFlow
import com.example.smonkey_android.util.asEventFlow
import kotlinx.coroutines.launch
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers

class CommunityViewModel(
    private val createCommunityUseCase: CreateCommunityUseCase,
    private val deleteCommunityUseCase: DeleteCommunityUseCase,
    private val fetchCommunityUseCase: FetchCommunityUseCase,
    private val updateCommunityUseCae: UpdateCommunityUseCae,
) : ViewModel() {

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    fun fetchCommunity(Category: CategoryType) {
        fetchCommunityUseCase.execute(
            Category, object : DisposableSingleObserver<FetchCommunityResponse>() {
                override fun onSuccess(t: FetchCommunityResponse) {
                    event(Event.FetchCommunity(t))
                }

                override fun onError(e: Throwable) {
                    event(Event.ErrorMessage("게시물을 불러오던 도중 문제가 발생하였습니다."))
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
        data class FetchCommunity(val fetchCommunityListResponse: FetchCommunityResponse) : Event()
    }
}