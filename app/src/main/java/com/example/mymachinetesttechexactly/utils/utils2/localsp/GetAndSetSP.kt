package com.user.nestmarket.utils.localsp

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class GetAndSetSP @Inject constructor(private val context: Context) {

    fun getSP(spName: String, spVariable: String): String {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences(spName, Context.MODE_PRIVATE)
        return sharedPreferences.getString(spVariable, "")!!
    }

    fun setSP(spName: String, spVariable: String, data: String) {
        val pref = context.getSharedPreferences(
            spName,
            Context.MODE_PRIVATE
        )
        val editor = pref.edit()
        editor.putString(spVariable, data)
        editor.apply()
    }

    fun getSharedPrefs(c: Context?, key: String?, default_value: String?): String? {
        return if (c == null) {
            default_value
        } else {
            val prefs = c.getSharedPreferences(
                SpHelper.APP_NAME,
                Context.MODE_PRIVATE
            )
            prefs.getString(key, default_value)
        }
    }

    fun setSharedPrefs(c: Context?, key: String?, value: String) {
        if (c != null) {
            val editor = c.getSharedPreferences(
                SpHelper.APP_NAME,
                Context.MODE_PRIVATE
            ).edit()
            editor.putString(key, value)
            editor.commit()
        }
    }
}