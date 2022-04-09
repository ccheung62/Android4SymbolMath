package com.example.a4symbolmath.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a4symbolmath.Problem
import com.example.a4symbolmath.ProblemAdapter
import com.example.a4symbolmath.R
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseQuery
import com.parse.ParseUser

private const val TAG = "HomeFragment"


class HomeFragment : Fragment() {

    lateinit var rvProblem : RecyclerView
    lateinit var adapter : ProblemAdapter

    var allProblems = ArrayList<Problem>()

    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle?
    ) : View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home , container , false)

    }

    override fun onViewCreated(view : View , savedInstanceState : Bundle?) {
        super.onViewCreated(view , savedInstanceState)

        val user = ParseUser.getCurrentUser()

        var username = user.username
        view.findViewById<TextView>(R.id.tvUsername).text = "Hello, $username!"


        var progressNum = user.get("goal")
        var currentNum = user.get("currentQuestion")
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
        progressBar.progress = currentNum as Int
        progressBar.max = progressNum as Int
        view.findViewById<TextView>(R.id.tvCurrentNumber).text = currentNum.toString()
        view.findViewById<TextView>(R.id.tvGoalNumber).text = progressNum.toString()

        rvProblem = view.findViewById(R.id.rvProblems)
        adapter = ProblemAdapter(requireContext(), allProblems)
        rvProblem.adapter = adapter
        rvProblem.layoutManager = LinearLayoutManager(requireContext())
        queryForProblems()
    }

    fun queryForProblems() {
        // Specify which class to query
        val query: ParseQuery<Problem> = ParseQuery.getQuery(Problem::class.java)
        query.include(Problem.KEY_USER)
        query.whereEqualTo(Problem.KEY_USER, ParseUser.getCurrentUser())
        // Return post in descending order
        query.addDescendingOrder("createdAt")
        query.setLimit(20)

        // Find all Problem
        query.findInBackground(object : FindCallback<Problem> {
            override fun done(problems: MutableList<Problem>?, e: ParseException?) {
                if (e != null) {
                    Log.e(TAG, "Error fetching problems")
                } else if (problems != null) {
                    adapter.clear()
                    allProblems.addAll(problems)
                    adapter.notifyDataSetChanged()
                }
            }
        })
    }
}
