package com.example.retrofitexample.repository.service

import com.example.retrofitexample.model.Movie
import com.example.retrofitexample.repository.response.MovieResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface MovieService {

    @GET("movie/popular")
    fun getMovieList(@Query("api_key") api_Key: String): Observable<MovieResponse>
}