package com.example.bai229_10

import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cấu hình Edge-to-Edge nếu cần
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Danh sách các sản phẩm mẫu
        val products = listOf(
            Product("iPhone 15", "$999", "Available", true),
            Product("MacBook Pro", "$1999", "Out of stock", false),
            Product("AirPods Pro", "$249", "Available", true),
            Product("iPad Pro", "$799", "Available", true),
            Product("Apple Watch", "$399", "Available", false),
            Product("HomePod", "$299", "Out of stock", true),
            Product("Apple TV", "$179", "Available", true),
            Product("Magic Keyboard", "$99", "Available", false),
            Product("iMac", "$1299", "Available", true),
            Product("Mac Mini", "$699", "Available", false)
            // Thêm nhiều sản phẩm nếu cần
        )

        // Tìm GridView và gán adapter
        val gridView: GridView = findViewById(R.id.gridView)
        val adapter = ProductAdapter(this, products)
        gridView.adapter = adapter
    }
}
