package com.belarusianin.quizest.presentation.model.event

sealed interface NavEvent : UiEvent {
    object NavBack : NavEvent
}