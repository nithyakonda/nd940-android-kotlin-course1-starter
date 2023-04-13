package com.udacity.shoestore.screens.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListViewModel : ViewModel() {
    private val shoes = mutableListOf<Shoe>()

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList : LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val _hasLoggedIn = MutableLiveData<Boolean>()
    val hasLoggedIn : LiveData<Boolean>
        get() = _hasLoggedIn

    init {
        _shoeList.value = mutableListOf()
        _hasLoggedIn.value = false
    }

    fun onSave(shoe : Shoe) {
        shoes.add(shoe)
        _shoeList.value = shoes
    }

    fun onLogin() {
        _hasLoggedIn.value = true
    }
}