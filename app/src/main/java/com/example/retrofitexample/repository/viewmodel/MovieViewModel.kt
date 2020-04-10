package com.example.retrofitexample.repository.viewmodel

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitexample.model.Movie
import com.example.retrofitexample.repository.MovieRepository

class MovieViewModel(@NonNull application: Application) : AndroidViewModel(application)  {

    private val movieRepository : MovieRepository = MovieRepository()

    fun getMovies() : LiveData<List<Movie>> {
       return  movieRepository.getLiveMovies()
    }

    fun clear() {
        movieRepository.clear()
    }

}