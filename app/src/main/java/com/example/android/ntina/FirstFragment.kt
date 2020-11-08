package com.example.android.ntina

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.preference.PreferenceManager

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var settings_set: Boolean = true
    private lateinit var warning:TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_first, container, false)

        warning = view.findViewById(R.id.set_settings)
        val l1: LinearLayout = view.findViewById(R.id.layout1)
        val l2: LinearLayout = view.findViewById(R.id.layout2)
        val l3: LinearLayout = view.findViewById(R.id.layout3)
        val l4: LinearLayout = view.findViewById(R.id.layout4)
        val l5: LinearLayout = view.findViewById(R.id.layout5)
        val l6: LinearLayout = view.findViewById(R.id.layout6)

        return view
    }

    override fun onResume() {
        super.onResume()
        val pm  = PreferenceManager.getDefaultSharedPreferences(requireContext())
        val prefName = pm.getString(getString(R.string.pref_name),"")
        val prefAddr = pm.getString(getString(R.string.pref_addr),"")

        settings_set = !(TextUtils.isEmpty(prefName) || TextUtils.isEmpty(prefAddr))

        if (settings_set){
            warning.visibility = View.GONE
        } else {
            warning.visibility = View.VISIBLE
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}