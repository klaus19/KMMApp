package com.example.kmmapp

import android.annotation.SuppressLint
import android.location.Geocoder
import com.google.android.gms.location.LocationServices
import java.util.*
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

actual class LocationController {



    @SuppressLint("Missing Permission", "MissingPermission")
    actual suspend fun getCurrentAddress():String?= suspendCoroutine {continuation->
        LocationServices.getFusedLocationProviderClient(appContext).lastLocation
            .addOnFailureListener { continuation.resume(null) }
            .addOnSuccessListener { location ->
                location?.let { _ ->
                    val geocoder = Geocoder(appContext, Locale.getDefault())
                    val address: String? = geocoder
                        .getFromLocation(location.latitude, location.longitude, 1)
                        .firstOrNull()
                        ?.thoroughfare

                    continuation.resume(address)
                }
            }
    }
}