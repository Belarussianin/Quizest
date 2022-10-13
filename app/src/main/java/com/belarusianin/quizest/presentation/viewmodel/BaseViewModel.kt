package com.belarusianin.quizest.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.belarusianin.quizest.presentation.model.UiEvent
import com.belarusianin.quizest.presentation.model.UiState

abstract class BaseViewModel<State, Event> : ViewModel() where State : Any, Event : UiEvent {

    abstract val state: LiveData<UiState<State>>

    /**
     * Send a DEBUG log message with event name and content.
     */
    open fun onEvent(event: Event) {
        Log.d(javaClass.simpleName, "Event $event")
    }
}