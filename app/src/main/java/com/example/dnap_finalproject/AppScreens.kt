package com.example.dnap_finalproject

sealed class AppScreens (
    val route: String
) {
    object LoginScreen: AppScreens("login_screen")
    object HomeScreen: AppScreens("home_screen")
    object RegisterScreen: AppScreens("register_screen")
    object HumidityScreen: AppScreens("humidity_screen")
    object TemperatureScreen: AppScreens("temperature_screen")
}