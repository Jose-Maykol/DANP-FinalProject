package com.example.dnap_finalproject.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ToggleButton(
    onButtonClick: () -> Unit,
    isOn: Boolean,
    messageOn: String = "{ \"message\": \"apagar_led\" }",
    messageOff: String = "{ \"message\": \"encender_led\" }"
) {

    IconButton(
        onClick = {onButtonClick()},
        modifier = Modifier
            .size(60.dp)
            .clip(CircleShape)
            .background(if (isOn) MaterialTheme.colors.primary else Color.Gray),
    ) {
        Icon(
            imageVector = if (isOn) Icons.Default.Check else Icons.Default.Check,
            contentDescription = "Toggle Button",
            tint = Color.White
        )
    }

    LaunchedEffect(isOn) {
        val message = if (isOn) messageOn else messageOff
        Log.d("ToggleButton", "Sending MQTT message: $message")
        onButtonClick()
    }
}
