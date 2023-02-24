package com.example.weathercomposeapp.view

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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                            WeatherScreen(data = it)
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
        WeatherScreen(data = FixedData.fixedData)
    }
}

//@RequiresApi(Build.VERSION_CODES.O)
//@Preview(showBackground = true, widthDp = 400, heightDp = 400, backgroundColor = 54432)
//@Composable
//fun DefaultPreview() {
//    SecondCard(data = FixedData.fixedData)
//}


//@RequiresApi(Build.VERSION_CODES.O)
//@Preview(showBackground = true, widthDp = 400, heightDp = 400, backgroundColor = 54432)
//@Composable
//fun DefaultPreview() {
//    ThirdCard(data = FixedData.fixedData)
//}