package com.example.a4symbolmath.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.a4symbolmath.ProblemDisplay
import com.example.a4symbolmath.R


class GenerateFragment : Fragment() {
    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle?
    ) : View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_generate , container , false)
    }

    override fun onViewCreated(view : View , savedInstanceState : Bundle?) {
        super.onViewCreated(view , savedInstanceState)
        view.findViewById<Button>(R.id.buttonAddition).setOnClickListener {
            verify("+")
        }
        view.findViewById<Button>(R.id.buttonSubtraction).setOnClickListener {
            verify("-")
        }
        view.findViewById<Button>(R.id.buttonMultiplication).setOnClickListener {
            verify("*")
        }
        view.findViewById<Button>(R.id.buttonDivision).setOnClickListener {
            verify("/")
        }

    }
    private fun verify( operation : String ){
        val max1 = view?.findViewById<EditText>(R.id.FirstNumberInput)?.text.toString()
        val max2 = view?.findViewById<EditText>(R.id.SecondNumberInput)?.text.toString()
        if(max1.isEmpty() || max2.isEmpty()){
            Toast.makeText(requireContext(),"Missing numbers", Toast.LENGTH_SHORT).show()
        }
        else{
            val i = Intent(requireContext(), ProblemDisplay::class.java)
            i.putExtra("operation",operation)
            i.putExtra("max1",max1)
            i.putExtra("max2",max2)
            startActivity(i)
        }
    }
}
