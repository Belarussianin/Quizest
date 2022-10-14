package com.belarusianin.quizest.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.belarusianin.quizest.presentation.model.UiEvent
import com.belarusianin.quizest.presentation.viewmodel.BaseViewModel

abstract class BaseFragment<Binding : ViewBinding, State : Any, Event : UiEvent> : Fragment() {

    private var _binding: Binding? = null
    protected val binding: Binding get() = _binding!!
    protected abstract fun getViewBinding(): Binding

    protected val viewModel: BaseViewModel<State, Event> get() = getBaseViewModel().value
    protected abstract fun getBaseViewModel(): Lazy<BaseViewModel<State, Event>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getViewBinding()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindUI()
        subscribeUI()
    }

    open fun bindUI() = binding

    open fun subscribeUI() = binding.apply {
        viewModel.state.observe(viewLifecycleOwner) { UiState ->
            com.belarusianin.quizest.presentation.model.UiState.process(UiState,
                onLoading = { processLoading() },
                onError = { message -> processError(message) },
                onReady = { state: State -> processState(state) }
            )
        }
    }

    abstract fun Binding.processLoading()

    abstract fun Binding.processError(message: String)

    abstract fun Binding.processState(state: State)

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}