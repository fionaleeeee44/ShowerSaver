package com.example.showersaver

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.showerapp.LoginActivity
import com.example.showersaverapor.R

class ForgotPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val inputEmail = findViewById<EditText>(R.id.inputEmail)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val backToLogin = findViewById<TextView>(R.id.backToLogin)

        btnSubmit.setOnClickListener {
            val email = inputEmail.text.toString().trim()

            if (email.isEmpty()) {
                Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Reset code sent to $email", Toast.LENGTH_LONG).show()
            }
        }

        backToLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
