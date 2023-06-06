package com.example.hotelbookingapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hotelbookingapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.txtSignup.setOnClickListener {
            val intent = Intent(this@LoginActivity, SignupActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.edtTxtLoginEmail.text.toString()
            val password = binding.edtTxtPassword.text.toString()

            when {
                email.isNotEmpty() && password.isNotEmpty() -> {
                    firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(intent)
                            Toast.makeText(this, "Signed in successfully", Toast.LENGTH_SHORT).show()
                            finish()
                        }else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                email.isEmpty() && password.isEmpty() -> {
                    Toast.makeText(this, "User not Found!!", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "One or More fields are empty!!!", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}