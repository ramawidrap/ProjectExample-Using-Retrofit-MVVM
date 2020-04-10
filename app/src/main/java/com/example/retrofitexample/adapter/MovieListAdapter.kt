package com.example.retrofitexample.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitexample.DetailMovie
import com.example.retrofitexample.R
import com.example.retrofitexample.model.Movie
import kotlinx.android.synthetic.main.movie_list.view.*

const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500/"

class MovieListAdapter(
    val context: Context,
    val listMovie : List<Movie>
)  : RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>(){


    class MovieListViewHolder(v : View) : RecyclerView.ViewHolder(v), View.OnClickListener{
        val movieImage = itemView.imageMovie_Iv
        val title = itemView.titleMovie_Tv
        val releaseDate = itemView.releaseMovie_Tv


        override fun onClick(v: View?) {
            Toast.makeText(v!!.context,"Click Detail",Toast.LENGTH_SHORT).show()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.movie_list,parent,false)
        return MovieListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.title.text = listMovie[position].title
        holder.releaseDate.text = listMovie[position].releaseDate
        val url =BASE_IMAGE_URL + listMovie[position].posterPath
        Glide.with(context).load(url).placeholder(R.drawable.placeholder).into(holder.movieImage)
        holder.itemView.setOnClickListener {
            val intent = Intent(context,DetailMovie::class.java)
            intent.putExtra("movie",listMovie.get(position))
            intent.putExtra("urlImage",url)
            context.startActivity(intent)
        }

    }
}