package com.xoulcarlos.android.ntina

import android.content.Context
import android.text.TextUtils
import androidx.preference.PreferenceManager

class Utils {
    companion object {

        fun isSettingsSet(context: Context): Boolean {
            val pm = PreferenceManager.getDefaultSharedPreferences(context)
            val prefName = pm.getString(context.getString(R.string.pref_name), "")
            val prefAddr = pm.getString(context.getString(R.string.pref_addr), "")
            return !(TextUtils.isEmpty(prefName) || TextUtils.isEmpty(prefAddr))
        }
    }
}