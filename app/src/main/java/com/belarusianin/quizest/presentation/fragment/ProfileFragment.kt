package com.belarusianin.quizest.presentation.fragment

import com.belarusianin.quizest.databinding.FragmentProfileBinding
import com.belarusianin.quizest.presentation.model.event.ProfileScreenEvent
import com.belarusianin.quizest.presentation.viewmodel.ProfileViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class ProfileFragment : BaseFragment<FragmentProfileBinding, Nothing, ProfileScreenEvent>() {
    override fun getViewBinding() = FragmentProfileBinding.inflate(layoutInflater)

    override fun getBaseViewModel() = viewModel<ProfileViewModel> { parametersOf(arguments) }.value
}