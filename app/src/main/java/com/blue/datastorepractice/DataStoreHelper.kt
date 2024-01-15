package com.blue.datastorepractice

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreHelper(
    private val context: Context
) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

    fun read(): Flow<Int>{
        val EXAMPLE_COUNTER = intPreferencesKey("example_counter")
        val exampleCounterFlow: Flow<Int> = context.dataStore.data
            .map { preferences ->
                preferences[EXAMPLE_COUNTER] ?: 0
            }

        return exampleCounterFlow
    }

    suspend fun add(){
        val EXAMPLE_COUNTER = intPreferencesKey("example_counter")
        context.dataStore.edit { settings->
            val currentCounterValue = settings[EXAMPLE_COUNTER] ?: 0
            settings[EXAMPLE_COUNTER] = currentCounterValue + 1
        }
    }
}