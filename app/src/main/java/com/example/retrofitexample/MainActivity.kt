package com.example.retrofitexample

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitexample.repository.viewmodel.MovieViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var movieViewModel : MovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.INTERNET), 0)
            } else {
                Toast.makeText(this,"Permission Granted",Toast.LENGTH_SHORT).show()
                // handle granted permission

                val fm = supportFragmentManager
                val ft = fm.beginTransaction()
                ft.add(R.id.fragment_container,ListMovieFragment.newInstance())
                ft.commit()
            }
        } // no need to ask permission

    }
}
