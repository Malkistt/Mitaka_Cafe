package com.example.mitakacafe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = intent.getStringExtra("EXTRA_NAME") ?: UserSession.getName(this)
        val address = intent.getStringExtra("EXTRA_ADDRESS") ?: "-"
        val notes = intent.getStringExtra("EXTRA_NOTES") ?: "-"

        findViewById<TextView>(R.id.tvConfirmName).text = name
        findViewById<TextView>(R.id.tvConfirmAddress).text = address
        findViewById<TextView>(R.id.tvConfirmNotes).text = notes
        findViewById<TextView>(R.id.tvConfirmPrice).text = CartManager.getTotalPriceString()

        val rvConfirmItems = findViewById<RecyclerView>(R.id.rvConfirmItems)
        rvConfirmItems.layoutManager = LinearLayoutManager(this)
        rvConfirmItems.adapter = MenuAdapter(CartManager.selectedItems) {
            // no-op
        }

        val btnOke = findViewById<Button>(R.id.btnOke)
        btnOke.setOnClickListener {
            CartManager.clear()
            val intent = Intent(this, HomeActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            }
            startActivity(intent)
            finish()
        }
    }
}
