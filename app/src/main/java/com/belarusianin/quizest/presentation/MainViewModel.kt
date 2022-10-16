package com.belarusianin.quizest.presentation

import androidx.lifecycle.MutableLiveData
import com.belarusianin.quizest.presentation.model.event.MainScreenEvent
import com.belarusianin.quizest.presentation.model.state.MainScreenUiState
import com.belarusianin.quizest.presentation.model.state.UiState
import com.belarusianin.quizest.presentation.viewmodel.BaseViewModel

class MainViewModel : BaseViewModel<MainScreenUiState, MainScreenEvent>() {

    override val state = MutableLiveData<UiState<MainScreenUiState>>(UiState.Loading)

    override fun onEvent(event: MainScreenEvent) {
        super.onEvent(event)
        when(event) {
            is MainScreenEvent.OnFloatButtonClick -> {
                state.postValue(UiState.Ready(MainScreenUiState(event.example)))
            }
            else -> {}
        }
    }
}