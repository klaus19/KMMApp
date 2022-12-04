package com.example.kmmapp.viewmodel

import com.example.kmmapp.LocationController
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LocationViewmodel:KMMViewmodel() {

    private val _address = MutableStateFlow<String?>(null)
    val address = _address.asStateFlow()

    private var loadAddressJob:Job?=null

    //Requires location permission
    fun loadAddress(){
        loadAddressJob?.cancel()
        coroutineScope.launch {
            _address.value = LocationController().getCurrentAddress()
        }
    }
}