package com.belarusianin.quizest.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.belarusianin.quizest.presentation.model.event.UiEvent
import com.belarusianin.quizest.presentation.model.state.UiState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.UNLIMITED

abstract class BaseViewModel<State, Event> : ViewModel() where State : Any, Event : UiEvent {

    open val state = object : LiveData<UiState<State>>() {}

    open fun onEvent(event: Event) {}
}