package com.example.homework5_tbc_it_academy

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homework5_tbc_it_academy.databinding.ActivityLogInBinding
import com.google.firebase.auth.FirebaseAuth

class LogInActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLogInBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.logInButtonLogInActivity.setOnClickListener {
            logIn()
        }

        binding.backButtonLogInButton.setOnClickListener {
            finish()
        }
    }

    private fun logIn() {
        firebaseAuth.signInWithEmailAndPassword(
            binding.emailTextFieldInputLogInActivity.text.toString(),
            binding.passwordFieldInputLogInActivity.text.toString()
        ).addOnCompleteListener {
            if (it.isSuccessful)
                Toast.makeText(this, R.string.successful_log_in, Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, R.string.failed_log_in, Toast.LENGTH_LONG).show()
        }
    }
}