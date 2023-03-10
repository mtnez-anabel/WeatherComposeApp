package com.example.weathercomposeapp.view

import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            weatherViewModel.onCreate()
            weatherViewModel.weatherModel.observe(this@MainActivity, Observer {
                Log.i("Data Weather............", it.toString())
                setContent {
                    WeatherComposeAppTheme {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colors.background
                        ) {
                            val configuration = LocalConfiguration.current
                            when (configuration.orientation) {
                                Configuration.ORIENTATION_LANDSCAPE -> {
                                    WeatherScreenLandscape(data = it, context = LocalContext.current
                                    )
                                }
                                Configuration.ORIENTATION_PORTRAIT -> {
                                    WeatherScreenPortrait(data = it, context = LocalContext.current)
                                }
                                else -> {}
                            }
                        }
                    }
                }
            })
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherComposeAppTheme {
        WeatherScreenPortrait(data = FixedData.fixedData, LocalContext.current)
    }
}

//@RequiresApi(Build.VERSION_CODES.O)
//@Preview(heightDp = 300, widthDp = 700)
//@Composable
//fun DefaultPreview() {
//    WeatherScreenLandscape(data = FixedData.fixedData, context = LocalContext.current)
//}