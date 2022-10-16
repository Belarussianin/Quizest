package com.belarusianin.quizest.presentation.fragment

import com.belarusianin.quizest.databinding.FragmentMainBinding
import com.belarusianin.quizest.presentation.MainViewModel
import com.belarusianin.quizest.presentation.model.event.MainScreenEvent
import com.belarusianin.quizest.presentation.model.state.MainScreenUiState
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.random.Random

class MainFragment : BaseFragment<FragmentMainBinding, MainScreenUiState, MainScreenEvent>() {
    override fun getViewBinding() = FragmentMainBinding.inflate(layoutInflater)

    override fun getBaseViewModel() = viewModel<MainViewModel>().value

    override fun bindUI() = super.bindUI().apply {
        floatingActionButton.setOnClickListener {
            viewModel.onEvent(MainScreenEvent.OnFloatButtonClick(Random.nextInt().toString()))
        }
    }

    override fun FragmentMainBinding.processError(message: String) {
        textView.text = message
    }

    override fun FragmentMainBinding.processState(state: MainScreenUiState) {
        textView.text = state.some
    }

    override fun navigate(event: MainScreenEvent) {
        when (event) {

            else -> super.navigate(event)
        }
    }
}