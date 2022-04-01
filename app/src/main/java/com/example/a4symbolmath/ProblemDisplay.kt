package com.example.a4symbolmath

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

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


c/*lass logic {
    init {
        val hist: ArrayList<history> = ArrayList<history>()

        val type = 0
        var sign = " "//replace this with operation
        var one = 0
        var two = 0
        var input = 2

        //stat tracking
        var total = 0
        var incorrect = 0

        var answer = true
        var loop = false
        var correct = true
        var realans = 0
        var digit1 = 2//replace this with max range
        var digit2 = 2//replace this with max range

        while (loop) {//start questions
            answer = true// used to determine when to move on to next question(maybe add a skip question)
            one = (Math.random() * digit1).toInt()
            two = (Math.random() * digit2).toInt()
            if (one < two) {
                val swap = one
                one = two
                two = swap
            }
            do { //repeat when wrong
                if (sign == "+") {
                    realans = one + two
                } else if (sign == "-") {
                    realans = one - two
                } else if (sign == "*") {
                    realans = one * two
                } else if (sign == "/")
                    realans = one / two
                    one = realans * two
                }while (sign == " ")
                try {
                    input = scan.nextInt()//change this to user input
                } catch (e: Exception) {//exit condition.. change to enter button
                    loop = false
                    break
                }
                if (realans == input) {
                    total++
                    val temp = history(one, two, input, true, sign) //ans t/f
                    println("Correct")
                    correct = true
                    hist.add(temp)
                } else {
                    val temp = history(one, two, input, false, sign) //ans t/f
                    println("Incorrect")
                    correct = false
                    incorrect++
                    hist.add(temp)
                }
            }
        }
        //start conclusion
    }
}*/

/*
class history(//first number(largest)
    private val one: Int, two: Int, ans: Int, answer: Boolean, sign: String?
) {
    private val two //second number
            : Int
    private val ans //
            : Int
    private val answer: Boolean
    private val form //printable
            : String

    fun one(): Int {
        return one
    }

    fun two(): Int {
        return two
    }

    fun ans(): Int {
        return ans
    }

    fun form(): String {
        return form
    }

    fun answer(): Boolean {
        return answer
    }

    */
/*
    constructor
    one is the first number
    two is the second number
    ans is the user input
    answer is if user was right or wrong
    form is a formatted readable string
    *//*

    init {
        one = one
        this.two = two
        this.ans = ans
        this.answer = answer
        form = String.format(
            "%2d%2s%3d%2s%1s%4d%1s%1s",
            one, sign, two, "=", " ", ans, " ", answer
        )
    }
}
*/
