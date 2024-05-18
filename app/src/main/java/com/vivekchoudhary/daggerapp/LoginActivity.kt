package com.vivekchoudhary.daggerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.vivekchoudhary.daggerapp.di.DaggerApplicationComponent
import com.vivekchoudhary.daggerapp.di.LoginComponent
import com.vivekchoudhary.daggerapp.ui.theme.DaggerAppTheme
import javax.inject.Inject

class LoginActivity : ComponentActivity() {

    private lateinit var loginComponent: LoginComponent
    @Inject lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        loginComponent = DaggerApplicationComponent.create().loginComponent().create()
        loginComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            DaggerAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(loginViewModel.getApiData())
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DaggerAppTheme {
        Greeting("Android")
    }
}