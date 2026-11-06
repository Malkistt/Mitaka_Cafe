package com.example.mitakacafe

import android.content.Context

object UserSession {
    private const val PREF_NAME = "CafePrefs"
    private const val KEY_NAME = "user_name"

    fun saveName(context: Context, name: String) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        prefs.edit().putString(KEY_NAME, name).apply()
    }

    fun getName(context: Context): String {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return prefs.getString(KEY_NAME, "Member") ?: "Member"
    }
}
