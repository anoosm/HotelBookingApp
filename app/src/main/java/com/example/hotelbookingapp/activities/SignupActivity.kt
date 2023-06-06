package com.example.hotelbookingapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hotelbookingapp.databinding.ActivtySignupBinding
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivtySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivtySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnSignup.setOnClickListener {
            val email = binding.edtTxtSignupEmail.text.toString()
            val password = binding.edtTxtSignupPassword.text.toString()
            val confirmPassword = binding.edtTxtConfirmPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                if (password == confirmPassword) {
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                        if(it.isSuccessful) {
                            val intent = Intent(this@SignupActivity, LoginActivity::class.java)
                            startActivity(intent)
                            finish()
                        }else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                }else {
                    Toast.makeText(this, "Passwords are not Matching!!", Toast.LENGTH_SHORT).show()
                }

            }else {
                Toast.makeText(this, "One or More fields are empty!!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}