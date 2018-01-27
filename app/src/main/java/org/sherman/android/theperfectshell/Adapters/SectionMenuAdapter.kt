package org.sherman.android.theperfectshell.Adapters

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import org.sherman.android.theperfectshell.Fragments.DialerFragment
import org.sherman.android.theperfectshell.Fragments.myMapFragment
import org.sherman.android.theperfectshell.Fragments.RecyclerFragment

// Menu Adapter
class SectionMenuAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): android.support.v4.app.Fragment {
        when (position) {
            0 -> return RecyclerFragment()
            1 -> return DialerFragment()
            2 -> return myMapFragment()
        }
        return null!!
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        when (position) {
            0 -> return "RECYCLER"
            1 -> return "DIALER"
            2 -> return "MAP"
        }
        return null!!
    }
}