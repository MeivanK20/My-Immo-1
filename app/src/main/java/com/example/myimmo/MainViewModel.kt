package com.example.myimmo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _properties = MutableLiveData<List<Property>>()
    val properties: LiveData<List<Property>> = _properties

    private val postgrest: Postgrest
        get() = SupabaseClient.client.postgrest

    fun fetchProperties() {
        viewModelScope.launch {
            try {
                val result = postgrest.from("properties").select().decodeList<Property>()
                _properties.postValue(result)
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
