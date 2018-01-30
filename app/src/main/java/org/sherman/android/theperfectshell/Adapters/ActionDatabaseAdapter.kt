package org.sherman.android.theperfectshell.Adapters

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import org.sherman.android.theperfectshell.Data.*

/**
 * Created by fyi2 on 1/30/18.
 */
class ActionDatabaseAdapter(context: Context):
        SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){


    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TRACKER_TABLE = "CREATE TABLE "+ TABLE_NAME+" ("+ KEY_ID+ " INTEGER PRIMARY KEY, "+
                KEY_STATUS+ " INTEGER, "+
                KEY_ACTION+ " TEXT )"

        db?.execSQL(CREATE_TRACKER_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        //create table again
        onCreate(db)
    }

    // CRUD

    fun createTodo(action: Action){
        var db:SQLiteDatabase = writableDatabase
        var valuesAction:ContentValues = ContentValues()

        valuesAction.put(KEY_ACTION,action.action)
        valuesAction.put(KEY_STATUS,action.status)

        db.insert(TABLE_NAME, null, valuesAction)
        return
    }

    fun readTodo(id: Int): Action{
        var db: SQLiteDatabase = readableDatabase
        var cursor:Cursor = db.query(TABLE_NAME, arrayOf(KEY_STATUS, KEY_ACTION), KEY_ID+"=?", arrayOf(id.toString()),null, null, null)

        if(cursor!=null)
            cursor.moveToFirst()

        var action = Action()
        action.status = cursor.getInt(cursor.getColumnIndex(KEY_STATUS))
        action.action = cursor.getString(cursor.getColumnIndex(KEY_ACTION))

        return action
    }

    fun readAllTodo(): ArrayList<Action> {
        val db: SQLiteDatabase = readableDatabase
        var list:ArrayList<Action> = ArrayList()
        var selectAll = "SELECT * FROM "+ TABLE_NAME
        var cursor: Cursor = db.rawQuery(selectAll,null)

        if (cursor.moveToFirst()){
            do {
                var action = Action()

                action.id = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                action.status = cursor.getInt((cursor.getColumnIndex(KEY_STATUS)))
                action.action = cursor.getString(cursor.getColumnIndex(KEY_ACTION))

                list.add(action)
            }while (cursor.moveToNext())
        }
        return list
    }

    fun updateTodo(action: Action): Int {
        var db:SQLiteDatabase = writableDatabase
        var valuesAction: ContentValues = ContentValues()

        valuesAction.put(KEY_ACTION, action.action)
        valuesAction.put(KEY_STATUS, action.status)

        val result = db.update(TABLE_NAME, valuesAction, KEY_ID+"=?", arrayOf(action.id.toString()))
        return result
    }

    fun deleteTodo(id:Int){
        var db:SQLiteDatabase = writableDatabase

        db.delete(TABLE_NAME, KEY_ID+"=?", arrayOf(id.toString()))
        //db.close()
    }

    fun getTodoCount(): Int {
        var db:SQLiteDatabase = readableDatabase
        var countQuery = "SELECT * FROM"+ TABLE_NAME
        var cursor:Cursor = db.rawQuery(countQuery, null)

        return cursor.count
    }
}