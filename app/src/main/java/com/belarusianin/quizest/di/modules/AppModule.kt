package com.belarusianin.quizest.di.modules

import com.belarusianin.quizest.data.repository.ExampleRepository
import com.belarusianin.quizest.presentation.MainViewModel
import com.belarusianin.quizest.presentation.viewmodel.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.dsl.module

val appModule = module {
    single { ExampleRepository(get()) }

    viewModel { MainViewModel() }
    viewModel { ProfileViewModel() }
}