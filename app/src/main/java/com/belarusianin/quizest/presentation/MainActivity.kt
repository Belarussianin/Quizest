package com.belarusianin.quizest.presentation

import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import com.belarusianin.quizest.databinding.ActivityMainBinding
import com.belarusianin.quizest.presentation.activity.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val binding by viewBinding(ActivityMainBinding::inflate)

    override fun ActivityMainBinding.bindUI() {
        val navController = getNavController(binding.fragmentContainerView.id)
        binding.setupBottomNav(navController)
    }

    private fun ActivityMainBinding.setupBottomNav(navController: NavController) {
        bottomNav.setupWithNavController(navController)
    }
}