package com.android.practice.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.android.practice.R
import com.android.practice.databinding.ActivityStateFlowBinding
import com.android.practice.utils.viewBinding
import com.android.practice.viewmodels.StateFlowViewModel
import com.android.practice.viewmodels.StateFlowViewModel.LoginUiState
import com.android.practice.viewmodels.StateFlowViewModel.LoginUiState.Empty
import com.android.practice.viewmodels.StateFlowViewModel.LoginUiState.Error
import com.android.practice.viewmodels.StateFlowViewModel.LoginUiState.Loading
import com.android.practice.viewmodels.StateFlowViewModel.LoginUiState.Success
import kotlinx.coroutines.launch

class StateFlowActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityStateFlowBinding::inflate)
    private val viewModel : StateFlowViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.loginUiState.collect{
                    when(it){
                        Empty -> TODO()
                        is Error -> TODO()
                        Loading -> TODO()
                        Success -> TODO()
                    }
                }
            }
        }
    }
}