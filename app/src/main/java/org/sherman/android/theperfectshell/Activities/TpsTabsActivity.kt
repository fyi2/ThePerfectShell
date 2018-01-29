package org.sherman.android.theperfectshell.Activities

import android.app.FragmentManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import kotlinx.android.synthetic.main.activity_tps_tabs.*
import org.sherman.android.theperfectshell.Adapters.SectionMenuAdapter
import org.sherman.android.theperfectshell.Fragments.myMapFragment
import org.sherman.android.theperfectshell.R
import org.sherman.android.theperfectshell.R.id.container

class TpsTabsActivity : AppCompatActivity(){

    private val LOCATION_REQUEST_CODE = 101
    private lateinit var mMap: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tps_tabs)

        var sectionAdapter = SectionMenuAdapter(supportFragmentManager)
        viewPagerID.adapter = sectionAdapter
        tabs.setupWithViewPager(viewPagerID)
        tabs.setTabTextColors(Color.WHITE, Color.GREEN)

    }

    fun home(view: View) {
        val intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}