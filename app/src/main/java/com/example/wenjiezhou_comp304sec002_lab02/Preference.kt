package com.example.wenjiezhou_comp304sec002_lab02

import android.content.Context
import android.content.SharedPreferences

object Preference {
    private const val PREFERENCE_NAME = "MyPreferences"

    fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    fun saveSelectedHouse(context: Context, houseInformation: String) {
        val sharedPreferences = getSharedPreferences(context)
        val editor = sharedPreferences.edit()
        editor.putString(houseInformation, houseInformation)
        editor.apply()
    }

    fun removeSelectedHouse(context: Context, houseInformation: String) {
        val sharedPreferences = getSharedPreferences(context)
        val editor = sharedPreferences.edit()
        editor.remove(houseInformation)
        editor.apply()
    }

    fun getSelectedHouses(context: Context): List<String> {
        val sharedPreferences = getSharedPreferences(context)
        return sharedPreferences.all.keys.toList()
    }
}