package org.sherman.android.theperfectshell.Activities

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.view.View
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_tps_tabs.*
import org.sherman.android.theperfectshell.Adapters.SectionMenuAdapter
import org.sherman.android.theperfectshell.Fragments.myMapFragment
import org.sherman.android.theperfectshell.R

class TpsTabsActivity : AppCompatActivity(), OnMapReadyCallback{

    private val LOCATION_REQUEST_CODE = 101
    private var mMap: GoogleMap? = null

    override fun onMapReady(p0: GoogleMap?) {
            System.err.println("OnMapReady start")

            val sydney = LatLng(-34.0, 151.0);
            p0!!.addMarker(MarkerOptions().position(sydney).title("Seed nay"));
            p0!!.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            Toast.makeText(this, "OnMapReady end", Toast.LENGTH_LONG).show()
    }

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

    private fun requestPermission(permissionType: String,
                                  requestCode: Int) {

        ActivityCompat.requestPermissions(this,
                arrayOf(permissionType), requestCode
        )
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {

        when (requestCode) {
            LOCATION_REQUEST_CODE -> {

                if (grantResults.isEmpty() || grantResults[0] !=
                        PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this,
                            "Unable to show location - permission required",
                            Toast.LENGTH_LONG).show()
                } else {

                    val mapFragment = supportFragmentManager
                            .findFragmentById(R.id.map) as SupportMapFragment
                    mapFragment.getMapAsync(this)
                }
            }
        }
    }

}
