package com.example.retrofitexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.retrofitexample.model.Movie
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovie : AppCompatActivity() {

    private lateinit var movie : Movie
    private lateinit var urlImage : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        val intent = getIntent()
        movie = intent.getParcelableExtra("movie")
        urlImage = intent.getStringExtra("urlImage")

        supportActionBar!!.title = movie.title

            Glide.with(this).load(urlImage).placeholder(R.drawable.placeholder).into(imageDetail_Iv)
        description_Tv.text = movie.overview

    }
}
