package com.example.retrofitexample.repository.network

import com.example.retrofitexample.repository.service.MovieService
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitService {

    companion object {

        lateinit var retrofit: Retrofit

        const val BASE_URL = "https://api.themoviedb.org/3/"

        fun getService(): MovieService {
            retrofit =
                Retrofit.Builder().baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(MovieService::class.java)
        }
    }


}