package com.example.dnap_finalproject.screens

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.User

@Composable
fun RegisterScreen (
    navController: NavController? = null
) {
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp, horizontal = 32.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Registro de usuario",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.Center),
            fontSize = 24.sp,
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = apellido,
            onValueChange = { apellido = it },
            label = { Text("Apellido") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val item: User = User.builder()
                    .nombres(nombre)
                    .apellidos(apellido)
                    .email(email)
                    .password(password)
                    .build()
                Amplify.DataStore.save(
                    item,
                    { success -> Log.i("Amplify", "Saved item: " + success.item().nombres) },
                    { error -> Log.e("Amplify", "Could not save item to DataStore", error) }
                )
                navController?.navigate("login_screen")
            },
            modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(4.dp)).padding(10.dp)
        ) {
            Text(text = "Registrar")
        }
    }
}