package com.blue.datastorepractice

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {

    var helper: DataStoreHelper = DataStoreHelper(application.applicationContext)

    var data: LiveData<Int> = helper.read().asLiveData()

    fun addData(){
        viewModelScope.launch {
            helper.add()
        }
    }

}