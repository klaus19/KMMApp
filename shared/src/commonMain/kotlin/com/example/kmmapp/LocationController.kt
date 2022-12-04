package com.example.kmmapp

expect class LocationController() {

    suspend fun getCurrentAddress():String?
}