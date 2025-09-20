package com.example.showersaver

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.showersaverapor.R

class OtpVerificationActivity : AppCompatActivity() {

    private lateinit var otp1: EditText
    private lateinit var otp2: EditText
    private lateinit var otp3: EditText
    private lateinit var otp4: EditText
    private lateinit var otp5: EditText
    private lateinit var otp6: EditText
    private lateinit var btnVerify: Button
    private lateinit var resendText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_verification)

        otp1 = findViewById(R.id.otp1)
        otp2 = findViewById(R.id.otp2)
        otp3 = findViewById(R.id.otp3)
        otp4 = findViewById(R.id.otp4)
        otp5 = findViewById(R.id.otp5)
        otp6 = findViewById(R.id.otp6)
        btnVerify = findViewById(R.id.btnVerify)
        resendText = findViewById(R.id.resendText)

        setupOtpInput()

        btnVerify.setOnClickListener {
            val otpCode = otp1.text.toString().trim() +
                    otp2.text.toString().trim() +
                    otp3.text.toString().trim() +
                    otp4.text.toString().trim() +
                    otp5.text.toString().trim() +
                    otp6.text.toString().trim()

            if (otpCode.length == 6) {
                Toast.makeText(this, "OTP Verified: $otpCode", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Please enter all 6 digits", Toast.LENGTH_SHORT).show()
            }
        }

        resendText.setOnClickListener {
            Toast.makeText(this, "OTP Resent!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupOtpInput() {
        val otpFields = arrayOf(otp1, otp2, otp3, otp4, otp5, otp6)

        for (i in otpFields.indices) {
            otpFields[i].addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (s?.length == 1 && i < otpFields.size - 1) {
                        otpFields[i + 1].requestFocus()
                    } else if (s?.isEmpty() == true && i > 0) {
                        otpFields[i - 1].requestFocus()
                    }
                }
                override fun afterTextChanged(s: Editable?) {}
            })
        }
    }
}
