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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.textfield.TextInputEditText

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        tvTitle.text = "Halo, ${UserSession.getName(this)}!"

        val etNamaLengkap = findViewById<TextInputEditText>(R.id.etNamaLengkap)
        val etAlamat = findViewById<TextInputEditText>(R.id.etAlamat)
        val etCatatan = findViewById<TextInputEditText>(R.id.etCatatan)

        etNamaLengkap.setText(UserSession.getName(this))

        val rvOrderItems = findViewById<RecyclerView>(R.id.rvOrderItems)
        val tvTotalPrice = findViewById<TextView>(R.id.tvTotalPrice)

        rvOrderItems.layoutManager = LinearLayoutManager(this)
        val orderAdapter = MenuAdapter(CartManager.selectedItems) { menu ->
            // Optionally remove on click or do nothing
        }
        rvOrderItems.adapter = orderAdapter

        tvTotalPrice.text = CartManager.getTotalPriceString()

        val btnOrder = findViewById<Button>(R.id.btnOrder)

        btnOrder.setOnClickListener {
            val nama = etNamaLengkap.text.toString().trim()
            val alamat = etAlamat.text.toString().trim()
            val catatan = etCatatan.text.toString().trim()

            if (nama.isEmpty()) {
                etNamaLengkap.error = "Nama lengkap harus diisi"
                etNamaLengkap.requestFocus()
                return@setOnClickListener
            }
            if (alamat.isEmpty()) {
                etAlamat.error = "Alamat harus diisi"
                etAlamat.requestFocus()
                return@setOnClickListener
            }
            if (CartManager.selectedItems.isEmpty()) {
                Toast.makeText(this, "Silakan pilih menu terlebih dahulu di halaman Home", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val confirmIntent = Intent(this, ConfirmationActivity::class.java).apply {
                putExtra("EXTRA_NAME", nama)
                putExtra("EXTRA_ADDRESS", alamat)
                putExtra("EXTRA_NOTES", catatan.ifEmpty { "-" })
            }
            startActivity(confirmIntent)
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.selectedItemId = R.id.nav_order

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "Ke Halaman Home", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_order -> {
                    true
                }
                R.id.nav_profile -> {
                    Toast.makeText(this, "Ke Halaman Profile", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}
