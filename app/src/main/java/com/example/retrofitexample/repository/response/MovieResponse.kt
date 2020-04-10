package com.example.retrofitexample.repository.response


import com.example.retrofitexample.model.Movie
import com.google.gson.annotations.SerializedName

data class MovieResponse(

    @SerializedName("page")
    val page: Int,

    @SerializedName("total_pages")
    val totalPages: Int,

    @SerializedName("total_results")
    val totalResults: Int,

    @SerializedName("results")
    val results : ArrayList<Movie>

)