package org.sherman.android.theperfectshell.Fragments


import android.location.Address
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


import org.sherman.android.theperfectshell.R
import android.location.Geocoder
import android.util.Log
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback


/**
 * A simple [Fragment] subclass.
 */
class myMapFragment : SupportMapFragment(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap

    override fun onMapReady(map: GoogleMap?) {
        System.err.println("OnMapReady start")
        mMap = map as GoogleMap;

        val sydney = LatLng(-34.0, 151.0);
        mMap.addMarker(MarkerOptions().position(sydney).title("Seed nay"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        Toast.makeText(this.context, "OnMapReady end", Toast.LENGTH_LONG).show()
    }

}
/**
    var mLatLong = LatLng(0.0,0.0)
    var mGoogleMap: GoogleMap? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_map, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("DEBUG+++++++++++++++++","Activity Created")
        var mapFragment : SupportMapFragment?=null
        mapFragment= fragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync {
            onMapReady()


            Toast.makeText(activity,"dfgdg", Toast.LENGTH_LONG).show() }
        super.onActivityCreated(savedInstanceState)
    }
    fun onMapReady(googleMap: GoogleMap) {
        var location= getLatLongFromPlace("Marlborough, MA")
        googleMap!!.addMarker(MarkerOptions().position(location).title("Marker in Sydney"))
        googleMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(location,17.0f))

    }


    fun getLatLongFromPlace(place: String): LatLng {
        try {
            val selected_place_geocoder = Geocoder(context)
            val address: List<Address>?

            address = selected_place_geocoder.getFromLocationName(place, 5)

            if (address == null) {
                Log.d("DEBUG ======>",mLatLong.toString())

                return LatLng(45.0, 0.0)
            } else {
                val location = address[0]
                val lat = location.latitude
                val lng = location.longitude
                mLatLong = LatLng(lat, lng)

                Log.d("DEBUG ======>",mLatLong.toString())


                return mLatLong
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
        Log.d("DEBUG ======>",mLatLong.toString())

        return LatLng(0.0, 0.0)
    }

}// Required empty public constructor
**/