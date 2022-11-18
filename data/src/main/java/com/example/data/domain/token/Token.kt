package com.example.data.domain.token

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.data.domain.token.StorageImpl.Key.Token
import com.example.data.domain.token.StorageImpl.Key.master
import dagger.hilt.android.qualifiers.ApplicationContext

var ACCESS_TOKEN: String = "default"
var REFRESH_TOKEN: String = "default"
var masterYi: Boolean = false

interface Storage {

    fun saveMasterYi()

    fun fetchMasterYi(): Boolean

    fun logout()

    fun saveToken(token: String)

    fun fetchToken(): String
}

class StorageImpl(
    private val sharedPreferences: SharedPreferences
): Storage {

    override fun saveMasterYi() {
        editPreference { it.putBoolean(master.toString(), true) }
    }

    override fun fetchMasterYi(): Boolean =
        sharedPreferences.getBoolean(master.toString(), false)

    override fun logout() {
        editPreference { it.putBoolean(master.toString(), false) }
        editPreference { it.putString(Token, "") }
    }

    override fun saveToken(token: String) {
        editPreference { it.putString(Token, token) }
    }

    override fun fetchToken(): String =
        sharedPreferences.getString(Token, "")!!

    private fun editPreference(edit: (SharedPreferences.Editor) -> Unit) =
        sharedPreferences.edit().let {
            edit(it)
            it.apply()
        }

    private object Key {
        const val master: Boolean = false
        const val Token: String = "ACCESS_TOKEN"
    }
}
