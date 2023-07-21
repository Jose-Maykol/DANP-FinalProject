package com.example.dnap_finalproject.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SensorDataTemperature {

    val temperature: MutableState<Double> = mutableStateOf(0.0)

    fun updateTemperature(temperatureValue: Double) {
        temperature.value = temperatureValue
    }
}

class SensorDataViewModel : ViewModel() {
    val sensorDataTemperature = SensorDataTemperature()
}
