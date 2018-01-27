package org.sherman.android.theperfectshell.Adapters

import android.support.v4.app.FragmentManager
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import org.sherman.android.theperfectshell.Fragments.TpsBottomFragment
import org.sherman.android.theperfectshell.Fragments.TpsPage1Fragment
import org.sherman.android.theperfectshell.Fragments.TpsPage2Fragment
import org.sherman.android.theperfectshell.Fragments.TpsPage3Fragment

/**
 * Created by fyi2 on 1/25/18.
 */
class TPSFragmentAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm){

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return TpsPage1Fragment()
            1 -> return TpsPage2Fragment()
            2 -> return TpsPage3Fragment()
        }
        return TpsBottomFragment()
    }

    override fun getCount(): Int {
        return 3
    }
}