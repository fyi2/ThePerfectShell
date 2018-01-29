package org.sherman.android.theperfectshell.Fragments

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.sherman.android.theperfectshell.R
import com.google.android.gms.maps.MapFragment
import android.content.Context.LOCATION_SERVICE
import android.location.LocationManager






/**
 * A simple [Fragment] subclass.
 */
class myMapFragment : SupportMapFragment(){

    private lateinit var mMap: GoogleMap

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        getMapAsync(OnMapReadyCallback {
            mMap = it
            val sydney = LatLng(0.0, 151.0);
            mMap.addMarker(MarkerOptions().position(sydney).title("Seed nay"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        })
    }

    fun onMapReady(map: GoogleMap?) {

    }
}
