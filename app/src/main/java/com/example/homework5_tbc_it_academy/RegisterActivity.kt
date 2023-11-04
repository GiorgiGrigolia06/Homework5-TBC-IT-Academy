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

        lifecycleScope.launch {
            viewModel.uiState.collect {
                with(binding) {
                    emailTextFieldLayoutRegisterActivity.helperText = it.emailValidationText
                    passwordFieldLayoutRegisterActivity.helperText = it.passwordValidationText
                }
            }
        }

        binding.nextButton.setOnClickListener {
            viewModel.validateEmail(binding.emailTextFieldInput.text.toString())
            viewModel.validatePassword(binding.passwordFieldInputRegisterActivity.text.toString())

            if (viewModel.uiState.value.isValidEmail && viewModel.uiState.value.isValidPassword) {
                val intent = Intent(this, Register2Activity::class.java)
                startActivity(intent)
            }
        }

        binding.registerBackButton.setOnClickListener {
            finish()
        }
    }
}