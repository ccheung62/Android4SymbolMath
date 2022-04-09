import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a4symbolmath.Problem
import com.example.a4symbolmath.ProblemAdapter
import com.example.a4symbolmath.R
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseQuery
import com.parse.ParseUser

const val TAG = "FaveFragment"

class FaveFragment : Fragment() {

    lateinit var rvFavorite : RecyclerView
    lateinit var adapter : ProblemAdapter

    var allFavorite = ArrayList<Problem>()

    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle?
    ) : View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fave , container , false)
    }

    override fun onViewCreated(view : View , savedInstanceState : Bundle?) {
        super.onViewCreated(view , savedInstanceState)
        rvFavorite = view.findViewById(R.id.rvFavorite)
        adapter = ProblemAdapter(requireContext(), allFavorite)
        rvFavorite.adapter = adapter
        rvFavorite.layoutManager = LinearLayoutManager(requireContext())
        queryForProblems()
    }

    fun queryForProblems() {
        // Specify which class to query
        val query: ParseQuery<Problem> = ParseQuery.getQuery(Problem::class.java)
        query.include(Problem.KEY_USER)
        query.whereEqualTo(Problem.KEY_USER, ParseUser.getCurrentUser())
        query.whereEqualTo(Problem.KEY_FAVE, true)
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
                    allFavorite.addAll(problems)
                    adapter.notifyDataSetChanged()
                }
            }
        })
    }

}