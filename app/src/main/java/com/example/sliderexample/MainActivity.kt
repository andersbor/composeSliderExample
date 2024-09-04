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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    Column(modifier = modifier) {
        var sliderPosition by remember { mutableFloatStateOf(0f) }
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
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