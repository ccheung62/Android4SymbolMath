package com.example.a4symbolmath

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        findViewById<Button>(R.id.btChangeUsername).setOnClickListener{
            val username = findViewById<EditText>(R.id.etChangeUsername).text.toString()
            Toast.makeText(this, "Chaning username to $username", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btChangePassword).setOnClickListener{
            val password = findViewById<EditText>(R.id.etChangePassword).text.toString()
            Toast.makeText(this, "Chaning password to $password", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btChangeFontSize).setOnClickListener{
            val fontSize = findViewById<EditText>(R.id.etChangeFontSize).text.toString()
            if (fontSize.all { Character.isDigit(it) }) {
                Toast.makeText(this, "Changing font size to $fontSize", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Font size must be a number", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Switch>(R.id.swDarkMode).setOnCheckedChangeListener { _, isChecked ->
            val message = if (isChecked) "Dark Mode On" else "Dark Mode off"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}