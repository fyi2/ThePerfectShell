package org.sherman.android.theperfectshell.Data


val DEBUG = "DEBUG ===>"

enum class DRAW(val title:String){
    TITLE("Menu Draw"),
    FIRST("Toast"),
    SECOND("Snackbar"),
    THIRD("Dialog")
}

val DATABASE_VERSION : Int = 1
val DATABASE_NAME: String = "tps.db"
val TABLE_NAME: String = "theperfectshell"


//Column names
val KEY_ID: String = "id"
val KEY_STATUS:String = "status"
val KEY_ACTION:String = "action"
