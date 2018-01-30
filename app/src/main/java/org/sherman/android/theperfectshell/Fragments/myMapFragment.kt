package org.sherman.android.theperfectshell.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


/**
 * A simple [Fragment] subclass.
 */
class myMapFragment : SupportMapFragment(){

    private lateinit var mMap: GoogleMap

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        getMapAsync(OnMapReadyCallback {
            mMap = it
            val mCityLocation = LatLng(51.5074, 0.0)
            mMap.addMarker(MarkerOptions().position(mCityLocation).title("Seed nay"))
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mCityLocation,14.0f))
        })
    }

    fun onMapReady(map: GoogleMap?) {

    }
}
