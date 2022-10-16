package com.belarusianin.quizest.presentation.model.event

sealed interface MainScreenEvent : UiEvent {
    object NavigateToProfile : MainScreenEvent, NavEvent
    class OnFloatButtonClick(val example: String) : MainScreenEvent
}