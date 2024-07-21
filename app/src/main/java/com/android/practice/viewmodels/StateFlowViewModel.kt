package com.android.practice.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class StateFlowViewModel : ViewModel() {


    /* Live Data
    * In LiveData we usually have mutable and immutable variables
    * We expose one to the view and use it inside our Activity/Fragment
    * and other we use to update it in ViewModel
    * */

    /* State Flow
    * Similar to Live Data we use mutable & immutable variables
    * but we have to initialize it with some value
    * */

    private val _loginUiState = MutableStateFlow<LoginUiState>(LoginUiState.Empty) // Mutable
    val loginUiState = _loginUiState // immutable



    fun performLogin(userName : String, password : String) = viewModelScope.launch {
        _loginUiState.value = LoginUiState.Loading
        delay(3000)
        // Do Something with Android Response
        _loginUiState.value = LoginUiState.Success


    }


    sealed class LoginUiState {
        object Loading : LoginUiState()
        object Empty : LoginUiState()
        object Success : LoginUiState()
        data class Error(val message : String) : LoginUiState()
    }

}