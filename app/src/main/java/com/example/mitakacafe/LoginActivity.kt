package com.example.mitakacafe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewmodel.CreationExtras

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnlogin = findViewById<Button>(R.id.btnLogin)

        btnlogin.setOnClickListener {
            val Username = etUsername.text.toString().trim()
            val Password = etPassword.text.toString().trim()

            if (Username.isEmpty()){
                etUsername.error = "Nama lengkap harus diisi"
                etUsername.requestFocus()
                return@setOnClickListener
            }
            if (Password.isEmpty()){
                etPassword.error = "Password harus diisi"
                etPassword.requestFocus()
                return@setOnClickListener
            }
            Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

}