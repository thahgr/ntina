package com.xoulcarlos.android.ntina

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.startActivity
import androidx.preference.PreferenceManager


class ItemListener(
    _context: Context,
) :
    View.OnClickListener {

    private var context: Context = _context


    override fun onClick(v: View) {

        val id = v.id
        var code: Int = 0
        when (id) {
            R.id.layout1 -> code = 1
            R.id.layout2 -> code = 2
            R.id.layout3 -> code = 3
            R.id.layout4 -> code = 4
            R.id.layout5 -> code = 5
            R.id.layout6 -> code = 6
        }

        if (Utils.isSettingsSet(context)) {

            AlertDialog.Builder(context)
                .setTitle(R.string.app_name)
                .setMessage("Αποστολή κωδικού $code")
                .setPositiveButton(
                    context.getString(R.string.yes)
                ) { _, _ ->
                    sendSms(context, code)
                }.setNegativeButton(context.getString(R.string.cancel), null)
                .show()

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
        val intent = Intent(Intent.ACTION_SENDTO, uri)
        val body = "$code $prefName $prefAddr"
        intent.putExtra("sms_body", body)
        startActivity(context, intent, null)
    }

}