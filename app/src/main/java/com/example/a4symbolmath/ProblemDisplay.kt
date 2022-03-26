package com.example.a4symbolmath

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class ProblemDisplay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_problem_display)
        findViewById<Button>(R.id.quit).setOnClickListener{
            Toast.makeText(this, "Give up and return to difficulty select", Toast.LENGTH_SHORT).show()
        }
        findViewById<ImageButton>(R.id.favorite).setOnClickListener{
            Toast.makeText(this, "Add this problem to your favorites", Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.submit).setOnClickListener{
            Toast.makeText(this, "Finalize your answer and see if its right", Toast.LENGTH_SHORT).show()
        }
    }
}
