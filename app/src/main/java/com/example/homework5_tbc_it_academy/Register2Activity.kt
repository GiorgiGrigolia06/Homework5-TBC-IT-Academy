package com.example.homework5_tbc_it_academy

import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import androidx.appcompat.app.AppCompatActivity
import com.example.homework5_tbc_it_academy.databinding.ActivityRegister2Binding

class Register2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityRegister2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegister2Binding.inflate(layoutInflater)
        setContentView(binding.root)

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
    }

    companion object {
        const val TERMS_OF_SERVICE = "Terms of Service"
        const val PRIVACY_POLICY = "Privacy Policy"
    }
}