package com.example.project0

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.Observer
import com.example.project0.screens.LoadFileScreen
import com.example.project0.ui.theme.Project0Theme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project0Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoadFileScreen(
                        onClickJson = { viewModel.downloadJson() },
                        onCLickXml = { viewModel.downloadXml() }
                    )
                }
            }
        }
        viewModel.news.observe(this, Observer {
            Log.d("AAAA", it.toString())
        })
    }
}
