package com.xoulcarlos.android.ntina

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.telephony.SmsManager
import android.telephony.SubscriptionManager
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentActivity
import androidx.preference.PreferenceManager


class ItemListener(_context: Context) : View.OnClickListener {

    private var context: Context = _context

    companion object Codes {
        const val code1: Int = 1
        const val code2: Int = 2
        const val code3: Int = 3
        const val code4: Int = 4
        const val code5: Int = 5
        const val code6: Int = 6
        const val codeShop: Int = 7
    }

    override fun onClick(v: View) {

        val id = v.id
        var code: Int = 0
        when (id) {
            R.id.layout1 -> code = code1
            R.id.layout2 -> code = code2
            R.id.layout3 -> code = code3
            R.id.layout4 -> code = code4
            R.id.layout5 -> code = code5
            R.id.layout6 -> code = code6
            R.id.layoutShop -> code = codeShop
        }


        if (Utils.isSettingsSet(context)) {
            if (code in 1..6) {
                AlertDialog.Builder(context)
                    .setTitle(R.string.app_name)
                    .setMessage(context.getString(R.string.alert_code) + " $code")
                    .setPositiveButton(
                        context.getString(R.string.yes)
                    ) { _, _ ->
                        sendSms(context, code)
                    }.setNegativeButton(context.getString(R.string.cancel), null)
                    .show()
            } else {
                AlertDialog.Builder(context)
                    .setTitle(R.string.app_name)
                    .setMessage(context.getString(R.string.alert_shop))
                    .setPositiveButton(
                        context.getString(R.string.yes)
                    ) { _, _ ->
                        sendSmsShop(context)
                    }.setNegativeButton(context.getString(R.string.cancel), null)
                    .show()
            }

        } else {
            Toast.makeText(
                context,
                context.getString(R.string.toast_set_credentials),
                Toast.LENGTH_LONG
            ).show()
        }

    }

    private fun sendSms(context: Context, code: Int) {
        val pm = PreferenceManager.getDefaultSharedPreferences(context)
        val prefName = pm.getString(context.getString(R.string.pref_name), "")
        val prefAddr = pm.getString(context.getString(R.string.pref_addr), "")

        val uri: Uri = Uri.parse("smsto:13033")
        val body = "$code $prefName $prefAddr"

        actualSendSms(uri, body, context)
    }

    private fun sendSmsShop(context: Context) {
        val pm = PreferenceManager.getDefaultSharedPreferences(context)
        val prefName = pm.getString(context.getString(R.string.pref_name), "")
        val prefAddr = pm.getString(context.getString(R.string.pref_addr), "")

        val uri: Uri = Uri.parse("smsto:13032")
        val body = "$prefName $prefAddr"

        actualSendSms(uri, body, context)
    }

    private fun actualSendSms(uri: Uri, body: String, context: Context) {
        val intent = Intent(Intent.ACTION_SENDTO, uri)
        intent.putExtra("sms_body", body)
        startActivity(context, intent, null)
    }

}