package com.belarusianin.quizest.presentation.fragment

import com.belarusianin.quizest.databinding.FragmentMainBinding
import com.belarusianin.quizest.presentation.MainViewModel
import com.belarusianin.quizest.presentation.model.MainScreenEvent
import com.belarusianin.quizest.presentation.model.MainScreenUiState
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainScreenUiState, MainScreenEvent>() {
    override fun getViewBinding() = FragmentMainBinding.inflate(layoutInflater)

    override fun getBaseViewModel() = viewModel<MainViewModel>()

    override fun bindUI() = super.bindUI().apply {
        textView.text = "1"
        floatingActionButton.setOnClickListener {
            viewModel.onEvent(MainScreenEvent.OnFloatButtonClick("some argument"))
        }
    }

    override fun subscribeUI() = super.subscribeUI().apply {

    }

    override fun FragmentMainBinding.processLoading() {}

    override fun FragmentMainBinding.processError(message: String) {
        textView.text = message
    }

    override fun FragmentMainBinding.processState(state: MainScreenUiState) {
        textView.text = state.some
    }
}