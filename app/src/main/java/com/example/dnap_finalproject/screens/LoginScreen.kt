package com.example.dnap_finalproject.screens

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.amplifyframework.core.Amplify
import com.amplifyframework.core.model.query.Where
import com.amplifyframework.datastore.generated.model.User
import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.example.dnap_finalproject.R

@Composable
fun LoginScreen(
    navController: NavHostController? = null
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current

    val sharedPreferences = context.getSharedPreferences("user_preferences", Context.MODE_PRIVATE)
    val userEmail = sharedPreferences.getString("email", null)

    if (userEmail != null) {
        if (navController != null) {
            navController.navigate("home_screen") {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        }
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp, horizontal = 32.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.icon_app),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        )
        Text(
            text = "Bienvenido a MediSense !!!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.Center)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(10.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(10.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                Amplify.DataStore.query(
                    User::class.java,
                    Where.matches(User.EMAIL.eq(email)),
                    { users ->
                        if (!users.hasNext()) {
                            Handler(Looper.getMainLooper()).post {
                                Toast.makeText(context, "Usuario no encontrado", Toast.LENGTH_SHORT).show()
                            }
                        }

                        while (users.hasNext()) {
                            val user = users.next()
                            Log.i("USER", "Email: " + user.email)
                            Log.i("USER", "Password: " + user.password)

                            if (user.password.equals(password)) {
                                Handler(Looper.getMainLooper()).post {
                                    Toast.makeText(context, "Ingresando", Toast.LENGTH_SHORT).show()
                                    val editor: SharedPreferences.Editor = sharedPreferences.edit()
                                    editor.putString("email", email)
                                    editor.putString("name", user.nombres )
                                    editor.apply()
                                    navController?.navigate("home_screen")
                                }
                            } else {
                                Handler(Looper.getMainLooper()).post {
                                    Toast.makeText(context, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
                                }

                            }
                        }
                    },
                    { failure -> Log.e("Tutorial", "Could not query DataStore", failure) }
                )
                //navController?.navigate("home_screen")
            },
            modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(4.dp))
        ) {
            Text(text = "Iniciar sesión")
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(
            onClick = {
                navController?.navigate("register_screen")
                      },
            modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(4.dp)).background(color = Color.Transparent)
        ) {
            Text(
                text = buildAnnotatedString {
                    append("No tienes cuenta? ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Regístrate")
                    }
                },
                color = Color.Black
            )
        }
    }
}