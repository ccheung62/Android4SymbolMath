package com.example.a4symbolmath.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.example.a4symbolmath.OperationSelect
import com.example.a4symbolmath.Problem
import com.example.a4symbolmath.R
import com.parse.*

class SettingsFragment : Fragment() {
    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle?
    ) : View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings , container , false)
    }
    override fun onViewCreated(view : View , savedInstanceState : Bundle?) {
        super.onViewCreated(view , savedInstanceState)

        val user = ParseUser.getCurrentUser()

        view.findViewById<Button>(R.id.btChangeUsername).setOnClickListener{
            val username = view.findViewById<EditText>(R.id.etChangeUsername).text.toString()
            user.username = username
            user.saveInBackground()
            Toast.makeText(requireContext(),"Username Successfully Changed", Toast.LENGTH_SHORT).show()
        }
        view.findViewById<Button>(R.id.btChangePassword).setOnClickListener{
            val password = view.findViewById<EditText>(R.id.etChangePassword).text.toString()
            user.setPassword(password)
            user.saveInBackground()
            Toast.makeText(requireContext(),"Password Successfully Changed", Toast.LENGTH_SHORT).show()
        }
        view.findViewById<Button>(R.id.btChangeGoal).setOnClickListener{
            val goalNum = Integer.parseInt(view.findViewById<EditText>(R.id.etChangeGoal).text.toString())
            user.put("goal", goalNum)
            user.saveInBackground()
            Toast.makeText(requireContext(), "Daily Goal Successfully Changed", Toast.LENGTH_SHORT).show()
        }
    }

}