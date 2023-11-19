package com.example.project0

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.project0.models.NewsJsonModel
import com.example.project0.models.NewsXmlModel
import com.example.project0.network.NetworkService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class MainViewModel: ViewModel() {
    fun downloadJson() {
        var model: NewsJsonModel? = null
        CoroutineScope(Dispatchers.IO).async {
            try {
                model = NetworkService.getNewsJson()
                Log.d("AAAA", model.toString())
            } catch (e: Exception) {
                Log.e("AAAA", e.localizedMessage)
            }
        }
    }

    fun downloadXml() {
        var model: NewsXmlModel? = null
        CoroutineScope(Dispatchers.IO).async {
            try {
                model = NetworkService.getNewsXml()
                Log.d("AAAA", model.toString())
            } catch (e: Exception) {
                Log.e("AAAA", e.localizedMessage)
            }
        }
    }
}