package com.example.a4symbolmath

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.parse.ParseFile
import com.parse.ParseUser
import org.json.JSONException
import java.io.File

private const val TAG = "ProblemDisplay"

class ProblemDisplay : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_problem_display)
        val sign = intent.getStringExtra("operation")!!
        val max1 = Integer.parseInt(intent.getStringExtra("max1"))
        val max2 = Integer.parseInt(intent.getStringExtra("max2"))

        var one = (Math.random() * max1).toInt() + 1
        var two = (Math.random() * max2).toInt() + 1
        var realans = 0
        var total = 0
        var attempt = 0
        var incorrect = 0
        var fave = false

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
            gotoMainActivity()
        }
        findViewById<ImageButton>(R.id.favorite).setOnClickListener {
            fave = true
            Toast.makeText(this, "Add this problem to your favorites", Toast.LENGTH_SHORT)
                .show()
        }
        findViewById<Button>(R.id.submit).setOnClickListener {
            attempt++
            try{
                val input =
                    Integer.parseInt(findViewById<EditText>(R.id.userAnswer).text.toString())
                if (realans == input) {
                    total++
                    findViewById<TextView>(R.id.questionNumber).text = (total+1).toString()
                    Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show()
                    submitProblem(fave, one, two, sign, attempt, input)

                    fave = false
                    attempt = 0
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
    // Send a problem object to the Parse Server
    fun submitProblem(isFavorite: Boolean, firstNum : Int, secondNum : Int, sign : String, attempt : Int, answer : Int){
        val user = ParseUser.getCurrentUser()
        val curNum = user.get("currentQuestion") as Int
        user.put("currentQuestion", curNum+1)
        user.saveInBackground()

        // Create a problem object
        val problem = Problem()
        problem.setUser(user)
        problem.setFirstNum(firstNum)
        problem.setSecondNum(secondNum)
        problem.setFave(isFavorite)
        problem.setSign(sign)
        problem.setTotalAttempts(attempt)
        problem.setAnswer(answer)
        problem.saveInBackground { exception ->
            if (exception != null){
                Log.e(TAG, "Error while saving problem")
            } else {
                Log.i(TAG, "Successfully saved problem")
            }
        }
    }

    private fun gotoMainActivity() {
        val intent = Intent(this@ProblemDisplay, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}

