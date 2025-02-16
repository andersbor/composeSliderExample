package com.example.sliderexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sliderexample.ui.theme.SliderExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SliderExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SliderSample(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun SliderSample(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var sliderPosition by remember { mutableFloatStateOf(0f) }
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..100f,
            steps = 9, // number of inner points
            colors = SliderDefaults.colors(
                thumbColor = SliderDefaults.colors().thumbColor.copy(alpha = 0.5f)
            )
        )
        Text(text = "Slider position: $sliderPosition")
    }
}

@Preview(showBackground = true)
@Composable
fun SliderSamplePreview() {
    SliderExampleTheme {
        SliderSample()
    }
}