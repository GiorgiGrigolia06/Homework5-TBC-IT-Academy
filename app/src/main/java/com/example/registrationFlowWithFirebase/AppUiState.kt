package com.example.registrationFlowWithFirebase

data class AppUiState(
    val emailValidationText: String = "",
    val isValidEmail: Boolean = false,

    val passwordValidationText: String = "",
    val isValidPassword: Boolean = false
)