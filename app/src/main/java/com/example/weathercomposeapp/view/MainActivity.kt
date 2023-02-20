package com.example.weathercomposeapp.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.weathercomposeapp.repository_model.db.FixedData
import com.example.weathercomposeapp.ui.theme.WeatherComposeAppTheme
import com.example.weathercomposeapp.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val weatherViewModel: WeatherViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            weatherViewModel.onCreate()
            weatherViewModel.weatherModel.observe(this@MainActivity, Observer {
                Log.i("Data Weather............", it.toString())
                setContent {
                    WeatherComposeAppTheme {
                        // A surface container using the 'background' color from the theme
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colors.background
                        ) {
                            WeatherScreen(data = it)
                        }
                    }
                }
            })
        }

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherComposeAppTheme {
        WeatherScreen(data = FixedData.fixedData)
    }
}