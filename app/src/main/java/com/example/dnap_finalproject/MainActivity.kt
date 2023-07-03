package com.example.dnap_finalproject

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.amplifyframework.AmplifyException
import com.amplifyframework.api.aws.AWSApiPlugin
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.AWSDataStorePlugin
import com.amplifyframework.datastore.generated.model.User
import com.example.dnap_finalproject.ui.theme.DNAPFinalProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        try {
            Amplify.addPlugin(AWSApiPlugin()) // UNCOMMENT this line once backend is deployed
            Amplify.addPlugin(AWSDataStorePlugin())
            Amplify.configure(applicationContext)
            Log.i("Amplify", "Initialized Amplify")
        } catch (e: AmplifyException) {
            Log.e("Amplify", "Could not initialize Amplify", e)
        }

        val item: User = User.builder()
            .nombres("Lorem ipsum dolor sit amet")
            .apellidos("Lorem ipsum dolor sit amet")
            .email("Lorem ipsum dolor sit amet")
            .password("Lorem ipsum dolor sit amet")
            .build()
        Amplify.DataStore.save(
            item,
            { success -> Log.i("Amplify", "Saved item: " + success.item().nombres) },
            { error -> Log.e("Amplify", "Could not save item to DataStore", error) }
        )

        super.onCreate(savedInstanceState)
        setContent {
            DNAPFinalProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DNAPFinalProjectTheme {
        Greeting("Android")
    }
}