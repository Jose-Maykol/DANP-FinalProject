package com.example.dnap_finalproject.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize

import androidx.compose.material.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.dnap_finalproject.components.ToggleButton
import com.example.dnap_finalproject.mqtt.MqttConnection
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dnap_finalproject.components.Indicator
import com.example.dnap_finalproject.components.LineChart
import com.example.dnap_finalproject.data.SensorDataViewModel


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TemperatureScreen(
    navController: NavHostController
) {

    val context = LocalContext.current
    val mqttConnection = remember { MqttConnection(context) }
    var isOn by remember { mutableStateOf(false) }
    val sensorDataViewModel: SensorDataViewModel = viewModel()
    val temperature = sensorDataViewModel.sensorDataTemperature.temperature.value

    LaunchedEffect(Unit) {
        mqttConnection.subscribeToTopic("esp32/pub", 1, sensorDataViewModel.sensorDataTemperature)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Control de temperatura",
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(Alignment.Center)
                    ) },
                backgroundColor = Color.Transparent,
                contentColor = MaterialTheme.colors.primary,
                modifier = Modifier.padding(top = 32.dp),
                elevation = 0.dp,
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 16.dp, horizontal = 32.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            //val temperature = mqttObserver.temperature

            Indicator(indicatorValue = temperature.toInt() )
            Spacer(modifier = Modifier.height(16.dp))
            LineChart(yPoints = listOf(
                219f, 22f, 23f, 220f, 130f, 20f, 50f, 100f, 201f, 1f
            ),)
            Spacer(modifier = Modifier.height(16.dp))
            ToggleButton(
                onButtonClick = {
                    val message = if (isOn) "{ \"message\": \"apagar_led\" }" else "{ \"message\": \"encender_led\" }"
                    val topic = "esp32/sub"
                    val qos = 1
                    mqttConnection.publishMessage(message, topic, qos)
                    isOn = !isOn
                },
                isOn = isOn
            )
        }
    }
}