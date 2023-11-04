package com.example.homework5_tbc_it_academy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homework5_tbc_it_academy.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButtonLogInButton.setOnClickListener {
            finish()
        }
    }
}