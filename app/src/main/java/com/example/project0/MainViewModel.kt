package com.example.project0

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.project0.models.NewModel
import com.example.project0.network.models.NewsJsonModel
import com.example.project0.network.models.NewsXmlModel
import com.example.project0.network.NetworkService
import com.example.project0.repository.NewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val repository = NewsRepository(networkService = NetworkService())

    private val newsMutable = listOf<NewModel>().toMutableStateList()
    val news: List<NewModel>
        get() = newsMutable

    fun downloadJson() {
        CoroutineScope(Dispatchers.IO).async {
            try {
                val response = repository.getNewsJson()
                launch(Dispatchers.Main) {
                    newsMutable.addAll(response.sortedBy { it.date })
                }
            } catch (e: Throwable) {
                Log.e("AAAA", e.message.toString())
            }
        }
    }

    fun downloadXml() {
        CoroutineScope(Dispatchers.IO).async {
            try {
                val response = repository.getNewsXml()
                launch(Dispatchers.Main) {
                    newsMutable.addAll(response.sortedBy { it.date })
                }
            } catch (e: Exception) {
                Log.e("AAAA", e.message.toString())
            }
        }
    }

    fun clearNews() {
        newsMutable.clear()
    }
}