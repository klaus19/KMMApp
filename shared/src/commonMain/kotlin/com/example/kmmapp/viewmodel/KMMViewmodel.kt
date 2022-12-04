package com.example.kmmapp.viewmodel

import kotlinx.coroutines.CoroutineScope

expect abstract class KMMViewmodel() {

    fun dispose()
    protected open fun onCleared()
    val coroutineScope: CoroutineScope
}