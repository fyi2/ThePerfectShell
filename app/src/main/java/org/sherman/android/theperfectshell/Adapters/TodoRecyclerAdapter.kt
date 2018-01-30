package org.sherman.android.theperfectshell.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import kotlinx.android.synthetic.main.fragment_recycler.view.*
import org.sherman.android.theperfectshell.Data.Action
import org.sherman.android.theperfectshell.R

/**
 * Created by fyi2 on 1/30/18.
 */
class TodoRecyclerAdapter(context: Context, actions: ArrayList<Action>):
                RecyclerView.Adapter<TodoRecyclerAdapter.ViewHolder>(){

    val mContext = context
    val mActions = actions

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false)

        return ViewHolder(view, mContext, mActions)
    }

    override fun getItemCount(): Int {
        return mActions.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(mActions[position])
    }




    inner class ViewHolder(itemView: View, context: Context, list: ArrayList<Action>): RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var mContext= context
        val mList = list

        fun bindView(action: Action){
            val done:ToggleButton = itemView.findViewById<ToggleButton>(R.id.toggleButton)
            val todo:TextView = itemView.findViewById(R.id.tvItem)

            if (action.status == 1){
                done.textOn
            } else {
                done.textOff
            }
            todo.text = action.action
        }

        override fun onClick(view: View?){
            val mPosition:Int = adapterPosition
            val status = mList[mPosition]
            Toast.makeText(mContext,"Button Clicked",Toast.LENGTH_LONG).show()
        }

    }
}