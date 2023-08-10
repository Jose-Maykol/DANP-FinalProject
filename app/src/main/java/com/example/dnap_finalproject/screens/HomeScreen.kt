package com.example.dnap_finalproject.screens

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.ExitToApp
import androidx.navigation.NavHostController
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dnap_finalproject.ui.theme.Black100
import com.example.dnap_finalproject.ui.theme.Black50
import com.example.dnap_finalproject.ui.theme.Orange300
import com.example.dnap_finalproject.ui.theme.Orange400
import com.example.dnap_finalproject.ui.theme.Sky300
import com.example.dnap_finalproject.ui.theme.Sky400

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController
) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("user_preferences", Context.MODE_PRIVATE)
    val user = sharedPreferences.getString("name", null)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "")
                },
                actions = {
                    IconButton(
                        onClick = {
                            val editor: SharedPreferences.Editor = sharedPreferences.edit()
                            editor.remove("email")
                            editor.apply()
                            navController.navigate("login_screen") {
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        }
                    ) {
                        Icon(imageVector = Icons.Default.ExitToApp, contentDescription = null)
                    }
                },
                elevation = 0.dp,
                modifier = Modifier.fillMaxWidth()
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(Orange400),
            ) {
                if (user != null) {
                    Text(
                        text = "Bienvenido $user",
                        fontSize = 18.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 40.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .width(160.dp)
                        .height(160.dp)
                        .background(Black50, shape = RoundedCornerShape(16.dp))
                        .clickable {
                            navController.navigate("temperature_screen")
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("30°C", fontSize = 50.sp, color = Orange400, fontWeight = FontWeight.Bold)
                        Text("Temperatura", fontSize = 18.sp, color = Black100)
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                Box(
                    modifier = Modifier
                        .width(160.dp)
                        .height(160.dp)
                        .background(Black50, shape = RoundedCornerShape(16.dp))
                        .clickable {
                            navController.navigate("humidity_screen")
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("50%", fontSize = 50.sp, color = Sky400, fontWeight = FontWeight.Bold)
                        Text("Humedad", fontSize = 18.sp, color = Black100)
                    }
                }
            }
        }
    }
}