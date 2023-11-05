package com.example.homework5_tbc_it_academy

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.homework5_tbc_it_academy.databinding.ActivityRegisterBinding
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Observes input fields and, if necessary, shows validation messages.
        lifecycleScope.launch {
            viewModel.uiState.collect {
                with(binding) {
                    emailTextFieldLayoutRegisterActivity.helperText = it.emailValidationText
                    passwordFieldLayoutRegisterActivity.helperText = it.passwordValidationText
                }
            }
        }

        // Checks if user input is valid. If it is, saves it and navigates to the next stage of the registration.
        binding.nextButton.setOnClickListener {
            viewModel.validateEmail(binding.emailTextFieldInput.text.toString())
            viewModel.validatePassword(binding.passwordFieldInputRegisterActivity.text.toString())

            if (viewModel.uiState.value.isValidEmail && viewModel.uiState.value.isValidPassword) {
                val intent = Intent(this, Register2Activity::class.java)
                intent.putExtra(EMAIL, binding.emailTextFieldInput.text.toString())
                intent.putExtra(PASSWORD, binding.passwordFieldInputRegisterActivity.text.toString())
                startActivity(intent)
            }
        }

        binding.registerBackButton.setOnClickListener {
            finish()
        }
    }

    companion object {
        const val EMAIL = "email"
        const val PASSWORD = "password"
    }
}