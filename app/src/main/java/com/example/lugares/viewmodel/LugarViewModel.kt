package com.example.lugares.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.lugares.data.LugarDao
import com.example.lugares.data.LugarDatabase
import com.example.lugares.model.Lugar
import com.example.lugares.repository.LugarRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LugarViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    val text: LiveData<String> = _text

}
