package org.sherman.android.theperfectshell.Fragments

import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import org.sherman.android.theperfectshell.Interfaces.CommuncationManager

import org.sherman.android.theperfectshell.R

/**
 * A simple [Fragment] subclass.
 */
class TpsPage3Fragment : Fragment() {

    lateinit var mContext: Context


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mContext = activity.applicationContext
        return inflater!!.inflate(R.layout.fragment_tps_page3, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var cm = activity as CommuncationManager
        var stars = activity.findViewById<RatingBar>(R.id.rb_RatingBar)

        stars.setOnRatingBarChangeListener { ratingBar, fl, b ->
            val rbValue = stars.rating.toInt()
            val sharedPreferences: SharedPreferences = context.getSharedPreferences("org.sherman.android.theperfectshell.tps", android.content.Context.MODE_PRIVATE)
            sharedPreferences.edit().putInt("rb",rbValue).apply()
            cm.updateScore(mContext)
        }
    }

}// Required empty public constructor