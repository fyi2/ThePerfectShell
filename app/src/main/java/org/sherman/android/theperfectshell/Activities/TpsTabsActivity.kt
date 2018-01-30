package org.sherman.android.theperfectshell.Activities

import android.Manifest
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.maps.GoogleMap
import kotlinx.android.synthetic.main.activity_tps_tabs.*
import org.sherman.android.theperfectshell.Adapters.SectionMenuAdapter
import org.sherman.android.theperfectshell.R

class TpsTabsActivity : AppCompatActivity(){

    private var callIntent: Intent? = null

    private val LOCATION_REQUEST_CODE = 101
    private lateinit var mMap: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {

        var sectionAdapter: SectionMenuAdapter

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tps_tabs)

        sectionAdapter = SectionMenuAdapter(supportFragmentManager)
        viewPagerID.adapter = sectionAdapter
        tabs.setupWithViewPager(viewPagerID)
        tabs.setTabTextColors(Color.WHITE, Color.GREEN)

    }

    fun home(view: View) {
        val intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
    fun dialOut(view: View) {

        var mCall = findViewById<FloatingActionButton>(R.id.fabFAB1)

        mCall!!.setOnClickListener { _: View ->
            var callIntent = Intent(Intent.ACTION_CALL)
            callIntent!!.data = Uri.parse("tel:0123456789")

            val hasCallPhone = checkSelfPermission(android.Manifest.permission.CALL_PHONE)
            if (hasCallPhone != PackageManager.PERMISSION_GRANTED) {
                if (!shouldShowRequestPermissionRationale(android.Manifest.permission.CALL_PHONE)) {
                    showMessageOKCancel("You need to allow access to dialer",
                            DialogInterface.OnClickListener { _, _ ->
                                requestPermissions(arrayOf(android.Manifest.permission.CALL_PHONE),
                                        1)
                            })
                    return@setOnClickListener
                }
                requestPermissions(arrayOf(Manifest.permission.CALL_PHONE),
                        1)
                return@setOnClickListener
            }
            startActivity(callIntent)
        }
    }

    private fun showMessageOKCancel(message: String, okListener: DialogInterface.OnClickListener) {
        AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            1 -> if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission Granted
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT)
                        .show()
                startActivity(callIntent)
//                this.finish()
            } else {
                // Permission Denied
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT)
                        .show()
            }
            else -> super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }

    fun addToDo(view: View){
        Toast.makeText(this, "To Do Pressed",Toast.LENGTH_LONG).show()

    }


    fun deleteToDo(view: View){

    }

}
