package com.example.retrofitexample.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.retrofitexample.API_KEY
import com.example.retrofitexample.model.Movie
import com.example.retrofitexample.repository.network.RetrofitService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class MovieRepository() {

    val listMovie = mutableListOf<Movie>()
    private val listMovieMutableLiveData = MutableLiveData<List<Movie>>()
    private val errorMessage = MutableLiveData<Throwable>()
    val compositeDisposable = CompositeDisposable()

    init {
        getMovies()
    }

    private fun getMovies() {


        val service =
            RetrofitService.getService()
        val observable = service.getMovieList(API_KEY)


        compositeDisposable.add(observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).flatMap {
            Observable.fromIterable(it.results)
        }.subscribeWith(object : DisposableObserver<Movie>(){
            override fun onComplete() {
                listMovieMutableLiveData.postValue(listMovie)
            }

            override fun onError(e: Throwable) {
                errorMessage.postValue(e)
            }

            override fun onNext(t: Movie) {
                listMovie.add(t)
            }

        }))

    }

    fun getLiveMovies() : MutableLiveData<List<Movie>>{
        return listMovieMutableLiveData
    }

    fun clear() {
        compositeDisposable.clear()
    }

    fun error() : MutableLiveData<Throwable> {
        return errorMessage
    }

}