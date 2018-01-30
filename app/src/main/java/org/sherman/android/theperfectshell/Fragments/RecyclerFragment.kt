package org.sherman.android.theperfectshell.Fragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_recycler.*
import org.sherman.android.theperfectshell.Adapters.ActionDatabaseAdapter
import org.sherman.android.theperfectshell.Adapters.TodoRecyclerAdapter
import org.sherman.android.theperfectshell.Data.Action

import org.sherman.android.theperfectshell.R


/**
 * A simple [Fragment] subclass.
 */
class RecyclerFragment : Fragment() {
    var db:ActionDatabaseAdapter?=null
    var recyclerAdapter:TodoRecyclerAdapter?=null
    var todoArray:ArrayList<Action>?=null
    var todoList: ArrayList<Action>?=null
    var layoutManager:RecyclerView.LayoutManager?=null
    var mContext:Context?=null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val recyclerView = inflater!!.inflate(R.layout.fragment_recycler, container, false)
        mContext = recyclerView.context
        db = ActionDatabaseAdapter(mContext!!)
        todoArray = ArrayList<Action>()
        todoList = ArrayList()

        // Set up the Recycler
        layoutManager = LinearLayoutManager(mContext)
        recyclerAdapter = TodoRecyclerAdapter(mContext!!, todoList!!)

        val myRVRecyclerView = recyclerView.findViewById<RecyclerView>(R.id.rvRecyclerView)
        myRVRecyclerView.layoutManager = layoutManager
        myRVRecyclerView.adapter = recyclerAdapter

        //Load Data
        todoArray = db?.readAllTodo()

        // build the list
        for (t in todoArray!!.iterator()) {
            val action = Action()

            action.action = t.action
            action.status = t.status
            action.id = t.id

            todoList!!.add(t)
        }
        recyclerAdapter!!.notifyDataSetChanged()

        return recyclerView
    }

}// Required empty public constructor
