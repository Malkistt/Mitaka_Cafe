package com.example.mitakacafe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.textfield.TextInputEditText

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        val etNamaLengkap = findViewById<TextInputEditText>(R.id.etNamaLengkap)

        val currentName = UserSession.getName(this)
        tvTitle.text = "Halo, $currentName!"
        etNamaLengkap.setText(currentName)

        val btnSave = findViewById<Button>(R.id.btnSave)
        btnSave.setOnClickListener {
            val newName = etNamaLengkap.text.toString().trim()
            if (newName.isEmpty()) {
                etNamaLengkap.error = "Nama harus diisi"
                etNamaLengkap.requestFocus()
                return@setOnClickListener
            }

            UserSession.saveName(this, newName)
            tvTitle.text = "Halo, $newName!"
            Toast.makeText(this, "Profil berhasil disimpan", Toast.LENGTH_SHORT).show()
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.selectedItemId = R.id.nav_profile

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "Ke Halaman Home", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_order -> {
                    Toast.makeText(this, "Ke Halaman Order", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, OrderActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_profile -> {
                    true
                }
                else -> false
            }
        }
    }
}
