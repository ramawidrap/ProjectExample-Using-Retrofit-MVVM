package com.example.retrofitexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.retrofitexample.adapter.MovieListAdapter
import com.example.retrofitexample.model.Movie
import com.example.retrofitexample.repository.network.RetrofitService
import com.example.retrofitexample.repository.response.MovieResponse
import com.example.retrofitexample.repository.viewmodel.MovieViewModel

import kotlinx.android.synthetic.main.fragment_list_movie.*
import java.util.*
import java.util.function.Function
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass.
 */
const val API_KEY = "56881c78ed5ff32bc2d49d3a1da127cd"

class ListMovieFragment : Fragment() {




    private lateinit var movieViewModel : MovieViewModel
    private lateinit var adapter : MovieListAdapter
    private lateinit var movies : List<Movie>

    companion object {
        fun newInstance() : ListMovieFragment {
            return ListMovieFragment()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_list_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        swipeRefreshView.setColorSchemeResources(R.color.colorPrimary)
//        swipeRefreshView.setOnRefreshListener {
//
//        }

    }

    private fun initUI() {
        adapter = MovieListAdapter(this.context!!,movies)
        movieList_Rv.layoutManager = GridLayoutManager(this.context,2)
        movieList_Rv.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        movieViewModel.getMovies().observe(this.viewLifecycleOwner, Observer<List<Movie>>{
            movies = it
            initUI()
        })
    }



}
