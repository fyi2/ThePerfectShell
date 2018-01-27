package org.sherman.android.theperfectshell.Activities

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AlertDialog
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import org.sherman.android.theperfectshell.Data.DRAW
import org.sherman.android.theperfectshell.R
import org.sherman.android.theperfectshell.R.id.inner_constraint

class MainActivity : AppCompatActivity() {
    public var mDrawLayout:DrawerLayout? = null
    private var mActivityTitle: String?=null
    private var mAdapter: ArrayAdapter<String>? = null
    private var mDrawerToggle: ActionBarDrawerToggle? = null
    private var mDrawerList: ListView? = null
    private var mConstraint: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO Personalize Menu
        var inflater: LayoutInflater = layoutInflater
        var listViewHeader: View = inflater.inflate(R.layout.draw_heading,null, false)

        mDrawLayout = findViewById(R.id.drawer_layout)
        mActivityTitle = title.toString()
        mDrawerList = findViewById(R.id.navList)
        mDrawerList?.addHeaderView(listViewHeader)
        mConstraint = findViewById(inner_constraint)
        addDrawItems()
        setupDrawer()

// Set Up the draw hamburger
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setHomeButtonEnabled(true)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main, menu)

        val sharedPreferences: SharedPreferences = getSharedPreferences("org.sherman.android.theperfectshell.tps", android.content.Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("home","Marlborough, MA").apply()

        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId){
            (R.id.menu_settings) -> {
                loadProfile()
            }
            (R.id.menu_tabs) -> {
                loadTabs()
            }
            (R.id.menu_fragments) -> {
                loadFragments()
            }
            (R.id.menu_recycler) -> {
                loadProfile()
            }
            else -> {
                loadProfile()
            }
        }
        // This IF statement is needed for the Draw Menu
        if (mDrawerToggle!!.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item)
    }

    // Draw Menu Functions

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        mDrawerToggle?.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        mDrawerToggle?.onConfigurationChanged(newConfig)
    }

    fun addDrawItems() {
        val actionArray = mutableListOf<String>(DRAW.FIRST.title, DRAW.SECOND.title, DRAW.THIRD.title)
        mAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, actionArray )
        mDrawerList!!.adapter = mAdapter

        mDrawerList!!.setOnItemClickListener(AdapterView.OnItemClickListener { parent: AdapterView<*>, view:View, position:Int, id:Long ->
            when (position) {
                1 -> {
                    Toast.makeText(this, "Slice of Toast Sir?", Toast.LENGTH_SHORT).show()
                }
                2 -> {

                    Snackbar.make(mConstraint!!, "Tasty Snack instead Sir?", Snackbar.LENGTH_SHORT).show()
                }
                3 -> {
                    val builder : AlertDialog.Builder = AlertDialog.Builder(this)
                    builder.setTitle("Toast or Snackbar?")
                    builder.setMessage("Choose One please")
                    // add the buttons
                    builder.setPositiveButton("Toast", DialogInterface.OnClickListener { dialog2, which ->

                            Toast.makeText(applicationContext, "Slice of Toast Sir?", Toast.LENGTH_SHORT).show()


                    });
                    builder.setNeutralButton("Snackbar", DialogInterface.OnClickListener { dialog2, which ->
                        Snackbar.make(mConstraint!!, "Tasty Snack instead Sir?", Snackbar.LENGTH_SHORT).show()
                    });
                    builder.setNegativeButton("Cancel", null);

                    val dialog: AlertDialog = builder.create()
                    dialog.show()
                }
                else -> Toast.makeText(this, "Illegal Click", Toast.LENGTH_LONG).show()
            }
        })
    }

    fun setupDrawer() {
        mDrawerToggle = object : ActionBarDrawerToggle(this,mDrawLayout,
                R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state.  */
            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar()?.setTitle(DRAW.TITLE.title);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state.  */
            override fun onDrawerClosed(view: View) {
                super.onDrawerClosed(view);
                getSupportActionBar()?.setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        }
        mDrawerToggle!!.setDrawerIndicatorEnabled(true)
        mDrawLayout?.addDrawerListener(mDrawerToggle!!)
    }



    fun loadProfile() {
// Activity STUB
    }

    fun loadFragments() {
        val intent: Intent = Intent(this, TpsSwipeableActivity::class.java)
        startActivity(intent)
    }

    fun loadTabs() {
        val intent:Intent = Intent(this,TpsTabsActivity::class.java)
        startActivity(intent)
    }
}
