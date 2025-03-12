package com.example.appproject

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity) // Kiểm tra tên file XML

        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val getName = findViewById<EditText>(R.id.getName)
        val getAge = findViewById<EditText>(R.id.getAge)

        btnCheck.setOnClickListener {
            val name = getName.text.toString().trim()
            val ageStr = getAge.text.toString().trim()

            if (name.isEmpty() || ageStr.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val age = ageStr.toIntOrNull()
            if (age == null || age < 0) {
                Toast.makeText(this, "Tuổi không hợp lệ!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val message = when {
                age < 3 -> "Em bé"
                age < 7 -> "Trẻ em"
                age < 18 -> "Thanh thiếu niên"
                age < 65 -> "Người lớn"
                else -> "Người già"
            }

            Toast.makeText(this, "Họ tên: $name\nPhân loại: $message", Toast.LENGTH_LONG).show()
        }
    }
}