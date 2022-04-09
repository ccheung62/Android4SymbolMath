package com.example.a4symbolmath.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.a4symbolmath.OperationSelect
import com.example.a4symbolmath.R
import com.parse.ParseUser
import org.w3c.dom.Text

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle?
    ) : View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home , container , false)
    }

    override fun onViewCreated(view : View , savedInstanceState : Bundle?) {
        super.onViewCreated(view , savedInstanceState)

        var username = ParseUser.getCurrentUser().username
        view.findViewById<TextView>(R.id.tvUsername).text = "Hello, $username"

        view.findViewById<Button>(R.id.btPractice).setOnClickListener{
            val intent = Intent(requireContext(), OperationSelect::class.java)
            startActivity(intent)
        }

    }
}
