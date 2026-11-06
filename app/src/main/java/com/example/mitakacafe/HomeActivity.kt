package com.example.mitakacafe

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)
        tvGreeting.text = "Halo, ${UserSession.getName(this)}!"

        val rvMenu = findViewById<RecyclerView>(R.id.rvMenu)
        rvMenu.layoutManager = LinearLayoutManager(this)

        val dummyData = listOf(
            MenuModel(R.drawable.makanan_1, "Steak", "Daging sapi berkualitas", "Rp 220.000"),
            MenuModel(R.drawable.makanan_2, "Kentang Goreng", "Kentang dengan bumbu", "Rp 20.000"),
            MenuModel(R.drawable.makanan_3, "Mie Goreng", "Mie goreng dengan tambahan topping", "Rp 35.000"),
            MenuModel(R.drawable.minuman_1_cappuccino, "Cappuccino", "Espresso, foam susu lembut", "Rp 28.000"),
            MenuModel(R.drawable.minuman_2_kopi_susu, "Milk Coffee", "Kopi dicampur susu segar", "Rp 22.000"),
            MenuModel(R.drawable.minuman_3_cafe_latte, "Cafe Latte", "Kopi lembut dan creammy", "Rp 27.000")
        )

        val adapter = MenuAdapter(dummyData) { menu ->
            CartManager.add(menu)
            Toast.makeText(this, "${menu.title} ditambahkan ke pesanan", Toast.LENGTH_SHORT).show()
        }
        rvMenu.adapter = adapter

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.selectedItemId = R.id.nav_home

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    true
                }
                R.id.nav_order -> {
                    Toast.makeText(this, "Ke Halaman Order", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, OrderActivity::class.java)
                    startActivity(intent)
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
