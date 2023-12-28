package com.hanushchakvitalii.computervoicesystemstest

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hanushchakvitalii.computervoicesystemstest.entities.FilmEntity

class MainViewModel : ViewModel() {
    private val _filmList = MutableLiveData<List<FilmEntity>>()
    val filmList: LiveData<List<FilmEntity>> = _filmList


    init {
        _filmList.value = FakeRepository.getListFilm()

    }

    fun sortedByReleaseDate() {
        Log.d("target"," _filmList.value.toString()")
        _filmList.value?.sortedBy { it.releaseDate }


    }

    fun sortedByTitle() {
        Log.d("target"," _filmList.value.toString()")
        _filmList.value?.sortedBy { it.title }
    }

}