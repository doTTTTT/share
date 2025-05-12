package com.dot.share.common.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<E : ViewModelEvent> : ViewModel() {
    private val _event = MutableSharedFlow<E>(extraBufferCapacity = 1)
    val event: SharedFlow<E> = _event.asSharedFlow()

    fun ViewModel.sendEvents(vararg events: E) {
        viewModelScope.launch { events.forEach { event -> _event.emit(event) } }
    }

}

interface ViewModelEvent