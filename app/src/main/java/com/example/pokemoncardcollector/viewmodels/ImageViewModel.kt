package com.example.pokemoncardcollector.viewmodels

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.net.URI

class ImageViewModel: ViewModel() {

    lateinit var item: Uri
    lateinit var image: String

}