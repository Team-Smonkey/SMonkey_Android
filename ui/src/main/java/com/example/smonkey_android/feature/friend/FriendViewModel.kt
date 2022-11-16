package com.example.smonkey_android.feature.friend

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.domain.usecase.community.CreateCommunityUseCase
import com.example.data.domain.usecase.community.DeleteCommunityUseCase
import com.example.data.domain.usecase.community.FetchCommunityUseCase
import com.example.data.domain.usecase.community.UpdateCommunityUseCae
import com.example.data.domain.usecase.friend.AddFriendUseCase
import com.example.data.domain.usecase.friend.FetchFriendListUseCase
import com.example.data.domain.usecase.friend.ReceiveRequestUseCase
import com.example.data.domain.usecase.friend.RefuseRequestUseCase
import com.example.data.domain.usecase.friend.SearchFriendUseCase
import com.example.smonkey_android.feature.community.CommunityViewModel
import com.example.smonkey_android.util.MutableEventFlow
import com.example.smonkey_android.util.asEventFlow
import kotlinx.coroutines.launch

class FriendViewModel (
    private val addFriendUseCase: AddFriendUseCase,
    private val fetchFriendListUseCase: FetchFriendListUseCase,
    private val receiveRequestUseCase: ReceiveRequestUseCase,
    private val refuseRequestUseCase: RefuseRequestUseCase,
    private val searchFriendUseCase: SearchFriendUseCase
) : ViewModel() {

    private val _eventFlow = MutableEventFlow<CommunityViewModel.Event>()
    val eventFlow = _eventFlow.asEventFlow()

    private fun event(event: CommunityViewModel.Event) {
        viewModelScope.launch {
            _eventFlow.emit(event)
        }
    }
}