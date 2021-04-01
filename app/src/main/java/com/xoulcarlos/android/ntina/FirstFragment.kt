package com.xoulcarlos.android.ntina

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var warning:TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val listener = ItemListener(requireContext())

        warning = view.findViewById(R.id.set_settings)
        val l1: LinearLayout = view.findViewById(R.id.layout1)
        val l2: LinearLayout = view.findViewById(R.id.layout2)
        val l3: LinearLayout = view.findViewById(R.id.layout3)
        val l4: LinearLayout = view.findViewById(R.id.layout4)
        val l5: LinearLayout = view.findViewById(R.id.layout5)
        val l6: LinearLayout = view.findViewById(R.id.layout6)
        val lShop: LinearLayout = view.findViewById(R.id.layoutShop)

        l1.setOnClickListener(listener)
        l2.setOnClickListener(listener)
        l3.setOnClickListener(listener)
        l4.setOnClickListener(listener)
        l5.setOnClickListener(listener)
        l6.setOnClickListener(listener)
        lShop.setOnClickListener(listener)

        return view
    }

    override fun onResume() {
        super.onResume()

        if (Utils.isSettingsSet(requireContext())){
            warning.visibility = View.GONE
        } else {
            warning.visibility = View.VISIBLE
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}