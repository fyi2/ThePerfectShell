package org.sherman.android.theperfectshell.Fragments


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_tps_top.*
import org.sherman.android.theperfectshell.Activities.TpsSwipeableActivity
import org.sherman.android.theperfectshell.Interfaces.CommuncationManager

import org.sherman.android.theperfectshell.R
import java.io.StreamCorruptedException


/**
 * A simple [Fragment] subclass.
 */
class TpsPage1Fragment : Fragment() {
    lateinit var mContext: Context

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // inflater the view
        val returnView: View = inflater!!.inflate(R.layout.fragment_tps_page1, container, false)
        mContext = activity.applicationContext

        return returnView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var cm = activity as CommuncationManager
        val cbx1 : CheckBox = activity.findViewById(R.id.checkBox)
        val cbx2 : CheckBox = activity.findViewById(R.id.checkBox2)

        cbx1.setOnClickListener{
            val sharedPreferences: SharedPreferences = context.getSharedPreferences("org.sherman.android.theperfectshell.tps", android.content.Context.MODE_PRIVATE)
            sharedPreferences.edit().putBoolean("cbx_1",cbx1.isChecked).apply()
            cm.updateScore(mContext)
        }
        cbx2.setOnClickListener{
            val sharedPreferences: SharedPreferences = context.getSharedPreferences("org.sherman.android.theperfectshell.tps", android.content.Context.MODE_PRIVATE)
            sharedPreferences.edit().putBoolean("cbx_2",cbx2.isChecked).apply()
            cm.updateScore(mContext)
        }
    }

}
