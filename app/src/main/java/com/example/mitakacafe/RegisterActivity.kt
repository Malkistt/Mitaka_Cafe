package com.example.mitakacafe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etNamaLengkap = findViewById<EditText>(R.id.etNamaLengkap)
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val nama = etNamaLengkap.text.toString().trim()
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (nama.isEmpty()) {
                etNamaLengkap.error = "Nama lengkap harus diisi"
                etNamaLengkap.requestFocus()
                return@setOnClickListener
            }

            if (username.isEmpty()) {
                etUsername.error = "Username harus diisi"
                etUsername.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                etPassword.error = "Password harus diisi"
                etPassword.requestFocus()
                return@setOnClickListener
            }

            Toast.makeText(this, "Registrasi Berhasil!", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}