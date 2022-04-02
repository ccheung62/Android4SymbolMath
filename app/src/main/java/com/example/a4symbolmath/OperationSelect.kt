package com.example.a4symbolmath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class OperationSelect : AppCompatActivity() {


    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_operation)

        findViewById<Button>(R.id.buttonAddition).setOnClickListener {
            verify("+")
        }
        findViewById<Button>(R.id.buttonSubtraction).setOnClickListener {
            verify("-")
        }
        findViewById<Button>(R.id.buttonMultiplication).setOnClickListener {
            verify("*")
        }
        findViewById<Button>(R.id.buttonDivision).setOnClickListener {
            verify("/")
        }


    }

    private fun verify( operation : String ){
        val max1 = findViewById<EditText>(R.id.FirstNumberInput).text.toString()
        val max2 = findViewById<EditText>(R.id.SecondNumberInput).text.toString()
        if(max1.isEmpty() || max2.isEmpty()){
            Toast.makeText(this,"Missing numbers",Toast.LENGTH_SHORT).show()
        }
        else{
            val i = Intent(this,ProblemDisplay::class.java)
            i.putExtra("operation",operation)
            i.putExtra("max1",max1)
            i.putExtra("max2",max2)
            startActivity(i)
        }
    }

}