package org.sherman.android.theperfectshell.Activities

import android.app.DatePickerDialog
import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.fragment_tps_top.*
import org.sherman.android.theperfectshell.Adapters.TPSFragmentAdapter
import org.sherman.android.theperfectshell.Fragments.TpsTopFragment
import org.sherman.android.theperfectshell.Interfaces.CommuncationManager
import org.sherman.android.theperfectshell.R
import java.util.*

class TpsSwipeableActivity : FragmentActivity(), CommuncationManager {

    lateinit var pager:ViewPager
    lateinit var sharedPreferences: SharedPreferences
    lateinit var mContext: Context
    lateinit var fm: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tps_swipeable)

        sharedPreferences = getSharedPreferences("org.sherman.android.theperfectshell.File01", Context.MODE_PRIVATE)

        val adapter = TPSFragmentAdapter(supportFragmentManager)
        pager = findViewById<View>(R.id.swipe_area) as ViewPager
        pager.adapter = adapter
        adapter.notifyDataSetChanged()
    }


    override fun updateScore(context: Context) {
        var fm = getFragmentManager()
        var topFrag : TpsTopFragment = fm.findFragmentById(R.id.top_fragment) as TpsTopFragment
        topFrag.updateScore(context)
    }


    fun changeDate2(view: View) {

        var date: Calendar = Calendar.getInstance()
        var thisAYear = date.get(Calendar.YEAR).toInt()
        var thisAMonth = date.get(Calendar.MONTH).toInt()
        var thisADay = date.get(Calendar.DAY_OF_MONTH).toInt()

        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view2, thisYear, thisMonth, thisDay ->
            // Display Selected date in textbox
            thisAMonth = thisMonth + 1
            thisADay = thisDay
            thisAYear = thisYear

            statusDateID.setText("Date: " + thisAMonth + "/" + thisDay + "/" + thisYear)
            val newDate: Calendar = Calendar.getInstance()
            newDate.set(thisYear, thisMonth, thisDay)

        }, thisAYear, thisAMonth, thisADay)
        dpd.show()
    }


}
