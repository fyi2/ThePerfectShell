package org.sherman.android.theperfectshell.Fragments


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import org.sherman.android.theperfectshell.Interfaces.CommuncationManager

import org.sherman.android.theperfectshell.R


/**
 * A simple [Fragment] subclass.
 */
class TpsPage2Fragment : Fragment() {
    lateinit var mContext: Context

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        mContext = activity.applicationContext
        return inflater!!.inflate(R.layout.fragment_tps_page2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var cm = activity as CommuncationManager
        val sb = activity.findViewById<SeekBar>(R.id.seekBar)

        sb.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                return
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                return
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                var sbValue = p0!!.progress
                val sharedPreferences: SharedPreferences = context.getSharedPreferences("org.sherman.android.theperfectshell.tps", android.content.Context.MODE_PRIVATE)
                sharedPreferences.edit().putInt("sb",sbValue).apply()
                cm.updateScore(mContext)
            }
        })
    }
}
