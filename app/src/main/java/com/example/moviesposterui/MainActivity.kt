package com.example.moviesposterui


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.moviesposterui.navigation.SetupNavGraph
import com.example.moviesposterui.viewModel.MoviesDataViewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MoviesDataViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            SetupNavGraph(viewModel)

        }
    }
}

