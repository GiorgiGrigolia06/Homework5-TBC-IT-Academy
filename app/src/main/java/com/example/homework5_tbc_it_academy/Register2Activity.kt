package com.example.homework5_tbc_it_academy

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homework5_tbc_it_academy.databinding.ActivityRegister2Binding
import com.google.firebase.auth.FirebaseAuth

class Register2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityRegister2Binding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegister2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        val spannableText = SpannableString(binding.termsOfService.text)
        val termsStartIndex = binding.termsOfService.text.indexOf(TERMS_OF_SERVICE)
        val privacyStartIndex = binding.termsOfService.text.indexOf(PRIVACY_POLICY)

        spannableText.setSpan(
            UnderlineSpan(),
            termsStartIndex,
            termsStartIndex + TERMS_OF_SERVICE.length,
            0
        )

        spannableText.setSpan(
            UnderlineSpan(),
            privacyStartIndex,
            privacyStartIndex + PRIVACY_POLICY.length,
            0
        )

        binding.termsOfService.text = spannableText

        binding.register2BackButton.setOnClickListener {
            finish()
        }

        // If the username field is empty shows a warning toast message, else registers the user.
        binding.signUpButton.setOnClickListener {
            if (binding.usernameInput.text?.isNotBlank() == true) register()
            else Toast.makeText(this, R.string.username_blank, Toast.LENGTH_LONG).show()
        }
    }

    // Accesses the saved user input from previous activity and registers the user.
    private fun register() {
        firebaseAuth.createUserWithEmailAndPassword(
            intent.getStringExtra(EMAIL).toString(),
            intent.getStringExtra(PASSWORD).toString()
        ).addOnCompleteListener {
            if (it.isSuccessful) {
                val intent = Intent(this, LogInActivity::class.java)
                startActivity(intent)
            }
        }
    }

    companion object {
        const val TERMS_OF_SERVICE = "Terms of Service"
        const val PRIVACY_POLICY = "Privacy Policy"
        const val EMAIL = "email"
        const val PASSWORD = "password"
    }
}