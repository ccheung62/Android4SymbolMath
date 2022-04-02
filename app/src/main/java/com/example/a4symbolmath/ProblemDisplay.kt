package com.example.a4symbolmath

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONException

class ProblemDisplay : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_problem_display)
        val sign = intent.getStringExtra("operation")
        val max1 = Integer.parseInt(intent.getStringExtra("max1"))
        val max2 = Integer.parseInt(intent.getStringExtra("max2"))

        var one = (Math.random() * max1).toInt() + 1
        var two = (Math.random() * max2).toInt() + 1
        var realans = 0
        var total = 0
        var incorrect = 0

        findViewById<TextView>(R.id.questionNumber).text = (total+1).toString()

        if (one < two) {
            val swap = one
            one = two
            two = swap
        }

        if (sign == "+") {
            realans = one + two
            findViewById<TextView>(R.id.sign).text = "+"
        } else if (sign == "-") {
            realans = one - two
            findViewById<TextView>(R.id.sign).text = "-"
        } else if (sign == "*") {
            realans = one * two
            findViewById<TextView>(R.id.sign).text = "×"
        } else if (sign == "/") {
            realans = one / two
            one = realans * two
            findViewById<TextView>(R.id.sign).text = "÷"
        }

        findViewById<TextView>(R.id.firstNum).text = one.toString()
        findViewById<TextView>(R.id.secondNum).text = two.toString()

        findViewById<Button>(R.id.quit).setOnClickListener {
            Toast.makeText(this, "Give up and return to difficulty select", Toast.LENGTH_SHORT)
                .show()
        }
        findViewById<ImageButton>(R.id.favorite).setOnClickListener {
            Toast.makeText(this, "Add this problem to your favorites", Toast.LENGTH_SHORT)
                .show()
        }
        findViewById<Button>(R.id.submit).setOnClickListener {
            try{
                val input =
                    Integer.parseInt(findViewById<EditText>(R.id.userAnswer).text.toString())
                if (realans == input) {
                    total++
                    findViewById<TextView>(R.id.questionNumber).text = (total+1).toString()
                    Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show()

                    one = (Math.random() * max1).toInt() + 1
                    two = (Math.random() * max2).toInt() + 1
                    if (one < two) {
                        val swap = one
                        one = two
                        two = swap
                    }

                    if (sign == "+") {
                        realans = one + two
                        findViewById<TextView>(R.id.sign).text = "+"
                    } else if (sign == "-") {
                        realans = one - two
                        findViewById<TextView>(R.id.sign).text = "-"
                    } else if (sign == "*") {
                        realans = one * two
                        findViewById<TextView>(R.id.sign).text = "×"
                    } else if (sign == "/") {
                        realans = one / two
                        one = realans * two
                        findViewById<TextView>(R.id.sign).text = "÷"
                    }
                    findViewById<TextView>(R.id.firstNum).text = one.toString()
                    findViewById<TextView>(R.id.secondNum).text = two.toString()
                } else {
                    incorrect++
                    Toast.makeText(this, "INCORRECT", Toast.LENGTH_SHORT).show()
                }
            }catch(e: JSONException){
                Toast.makeText(this,"Put Some Answer",Toast.LENGTH_SHORT).show()
            }
        }
    }
}

