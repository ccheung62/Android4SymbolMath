package com.example.a4symbolmath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

private const val TAG = "LoginActivity"

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Check if the user is already logged in
//        if (ParseUser.getCurrentUser() != null){
//            gotoMainActivity()
//        }

        findViewById<Button>(R.id.btLogin).setOnClickListener {
            val username = findViewById<EditText>(R.id.etUsername).text.toString()
            val password = findViewById<EditText>(R.id.etPassword).text.toString()
            // loginUser(username, password)
            Toast.makeText(this, "Successfully logged on", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btRegister).setOnClickListener {
            val username = findViewById<EditText>(R.id.etUsername).text.toString()
            val password = findViewById<EditText>(R.id.etPassword).text.toString()
            // signUpUser(username, password)
            Toast.makeText(this, "Successfully registered", Toast.LENGTH_SHORT).show()
        }
    }

//    private fun signUpUser (username: String, password: String){
//        // Create the ParseUser
//        val user = ParseUser()
//
//        // Set fields for the user to be created
//        user.setUsername(username)
//        user.setPassword(password)
//
//        user.signUpInBackground { e ->
//            if (e == null) {
//                // The user had successfully signed up and signed in
//                Toast.makeText(this, "Successfully created an account", Toast.LENGTH_SHORT).show()
//                gotoMainActivity()
//            } else {
//                e.printStackTrace()
//                Toast.makeText(this, "Failed to sign up. Try again", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }

//    private fun loginUser (username: String, password: String){
//        ParseUser.logInInBackground(username, password, ({ user, e ->
//            if (user != null) {
//                Log.i(TAG, "user successfully logged in")
//                gotoMainActivity()
//            } else {
//                e.printStackTrace()
//                Toast.makeText(this, "Error logging in", Toast.LENGTH_SHORT).show()
//            }})
//        )
//    }

//    private fun gotoMainActivity() {
//        val intent = Intent(this@LoginActivity, MainActivity::class.java)
//        startActivity(intent)
//        finish()
//    }
}