package com.example.homework5_tbc_it_academy

data class AppUiState(
    val emailValidationText: String = "",
    val isValidEmail: Boolean = false,

    val passwordValidationText: String = "",
    val isValidPassword: Boolean = false
)