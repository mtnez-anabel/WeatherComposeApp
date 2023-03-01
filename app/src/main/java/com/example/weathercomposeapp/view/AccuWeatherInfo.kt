package com.example.weathercomposeapp.view

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weathercomposeapp.R

@Composable
fun AccuWeatherInfo( context: Context) {
    Row(
        modifier = Modifier.padding(8.dp).fillMaxWidth().clickable { onClick(context) },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.accuweather_link),
            fontSize = 20.sp,
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.End,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            style = MaterialTheme.typography.h3.copy(
                shadow = Shadow(
                    offset = Offset(14f, 14f),
                    blurRadius = 8f,
                    color = Color.Black.copy(alpha = 0.5f)
                )
            ),
            modifier = Modifier.padding(5.dp)

        )
        Image(
            painter = painterResource(id = R.drawable.accuweather_dark),
            contentDescription = "icon",
            contentScale = ContentScale.Fit,
            modifier = Modifier.padding(5.dp)
        )
    }
}

private fun onClick(context: Context) {
    context.startActivity(
        Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://www.accuweather.com")
        )
    )
}

