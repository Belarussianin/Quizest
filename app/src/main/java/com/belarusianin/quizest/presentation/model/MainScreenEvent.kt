package com.belarusianin.quizest.presentation.model

sealed class MainScreenEvent : UiEvent() {
    data class OnFloatButtonClick(val example: String) : MainScreenEvent()
}