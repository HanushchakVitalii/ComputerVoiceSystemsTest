package com.hanushchakvitalii.computervoicesystemstest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailFilmViewModel:ViewModel() {
    private val _isInWishlist = MutableLiveData<Boolean>()


    fun getIsInWishList(id : Int):LiveData<Boolean>{
        _isInWishlist.value = FakeRepository.isInWishlist(id)
        return _isInWishlist
    }

    fun updateIsInWishList(id: Int){
        FakeRepository.changeIsInWishlist(id)
        _isInWishlist.value = FakeRepository.isInWishlist(id)
    }



}