package com.example.dnap_finalproject.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "HOMEPAGE",
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(Alignment.Center)
                    ) },
                backgroundColor = Color.Transparent,
                contentColor = Color.White,
                modifier = Modifier.padding(top = 32.dp),
                elevation = 0.dp,
                actions = {
                    IconButton(
                        onClick = { navController?.navigate("hacerCita_screen")}
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Logout"
                        )
                    }
                },
            )
        }
    ) {
        Text(text = "Home Screen")
    }
}