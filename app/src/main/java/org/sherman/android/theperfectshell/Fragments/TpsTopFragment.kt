package org.sherman.android.theperfectshell.Fragments


import android.app.DatePickerDialog
import android.os.Bundle
import android.app.Fragment
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_tps_top.*

import org.sherman.android.theperfectshell.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class TpsTopFragment : Fragment() {
    //lateinit var score: TextView
    lateinit var mContext: Context


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tps_top, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //score = activity.findViewById(R.id.tv_Score)
        var calendar: Calendar = Calendar.getInstance()
        val dateFormat: DateFormat = SimpleDateFormat("MM/dd/yyy")
        statusDateID.setText("Date: " + dateFormat.format(calendar.time))
    }

    fun updateScore(context: Context) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("org.sherman.android.theperfectshell.tps", android.content.Context.MODE_PRIVATE)
        val cbx1 = sharedPreferences.getBoolean("cbx_1",true)
        val cbx2 = sharedPreferences.getBoolean("cbx_2",true)
        val sb = sharedPreferences.getInt("sb",0)
        val rb = sharedPreferences.getInt("rb",0)
        var runningScore = 0
        runningScore = runningScore + numberFromBoolean(cbx1)
        runningScore = runningScore + numberFromBoolean(cbx2)
        runningScore = runningScore + sb
        runningScore = runningScore + rb

        tv_Score.text = runningScore.toString()
    }

    fun numberFromBoolean(b:Boolean): Int {
        if(b){
            return 1
        } else {
            return 0
        }
    }
}
