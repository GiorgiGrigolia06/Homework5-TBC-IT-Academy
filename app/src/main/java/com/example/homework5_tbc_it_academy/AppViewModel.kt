package com.example.homework5_tbc_it_academy

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(AppUiState())
    val uiState: StateFlow<AppUiState> = _uiState.asStateFlow()

    fun validateEmail(email: String) {
        val isValidEmail = Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.isNotBlank()
        _uiState.update {
            it.copy(
                emailValidationText = if (isValidEmail) "" else INVALID_EMAIL_ADDRESS,
                isValidEmail = isValidEmail
            )
        }
    }

    fun validatePassword(password: String) {
        val isValidPassword = password.length >= PASSWORD_LENGTH
        _uiState.update {
            it.copy(
                passwordValidationText = if (isValidPassword) "" else INVALID_PASSWORD,
                isValidPassword = isValidPassword
            )
        }
    }

    companion object {
        const val INVALID_EMAIL_ADDRESS = "Invalid E-Mail address."
        const val INVALID_PASSWORD = "Password must contain at least 8 characters."
        const val PASSWORD_LENGTH = 8
    }
}