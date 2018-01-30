package org.sherman.android.theperfectshell.Fragments


import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import org.sherman.android.theperfectshell.R
import android.content.Intent
import android.net.Uri


/**
 * A simple [Fragment] subclass.
 */
class DialerFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view : View? =  inflater!!.inflate(R.layout.fragment_dialer, container, false)

        var tvName:TextView = view!!.findViewById(R.id.tvDialerTab)
        tvName.setBackgroundColor(Color.RED)
        tvName.text = "Dialer Tab text"
        var llDialer:LinearLayout = view!!.findViewById(R.id.llDialerTab)
        llDialer.setBackgroundColor(Color.CYAN)

        return view
    }

    fun dialOut(view: View){
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "5082519337"))
        startActivity(intent)
    }

}

