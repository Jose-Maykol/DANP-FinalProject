package com.example.dnap_finalproject

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dnap_finalproject.screens.HomeScreen
import com.example.dnap_finalproject.screens.HumidityScreen
import com.example.dnap_finalproject.screens.TemperatureScreen
import com.example.dnap_finalproject.screens.LoginScreen
import com.example.dnap_finalproject.screens.RegisterScreen

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.LoginScreen.route
    ) {
        composable(AppScreens.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(AppScreens.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(AppScreens.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
        composable(AppScreens.HumidityScreen.route) {
            HumidityScreen(navController = navController)
        }
        composable(AppScreens.TemperatureScreen.route) {
            TemperatureScreen(navController = navController)
        }
    }
}