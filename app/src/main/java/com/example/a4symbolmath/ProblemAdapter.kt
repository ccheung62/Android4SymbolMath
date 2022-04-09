package com.example.a4symbolmath

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProblemAdapter(val context: Context, val problems: ArrayList<Problem>) : RecyclerView.Adapter<ProblemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProblemAdapter.ViewHolder {
        // Specify the layout file to use for this item
        val view = LayoutInflater.from(context).inflate(R.layout.item_problem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProblemAdapter.ViewHolder, position: Int) {
        val problem = problems.get(position)
        holder.bind(problem)
    }

    override fun getItemCount(): Int {
        return problems.size
    }

    class ViewHolder (itemView : View): RecyclerView.ViewHolder(itemView) {
        val tvFirstNum : TextView
        val tvSecondNum : TextView
        val tvSign : TextView
        val tvAns : TextView
        val ivFavorite : ImageView
        val tvAttemptNumber : TextView

        init {
            tvFirstNum = itemView.findViewById(R.id.tvFirstNum)
            tvSecondNum = itemView.findViewById(R.id.tvSecondNum)
            tvSign = itemView.findViewById(R.id.tvSign)
            tvAns = itemView.findViewById(R.id.tvAns)
            ivFavorite = itemView.findViewById(R.id.ivFavorite)
            tvAttemptNumber = itemView.findViewById(R.id.tvAttemptNumber)
        }

        fun bind(problem : Problem){
            tvFirstNum.text = problem.getFirstNum().toString()
            tvSecondNum.text = problem.getSecondNum().toString()
            tvSign.text = problem.getSign()
            tvAns.text = problem.getAnswer().toString()
            tvAttemptNumber.text = problem.getTotalAttempts().toString()
            if (problem.getFave()){
                ivFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
            } else {
                ivFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            }
        }
    }

    fun clear() {
        problems.clear()
        notifyDataSetChanged()
    }
}