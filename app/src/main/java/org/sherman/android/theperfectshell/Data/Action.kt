package org.sherman.android.theperfectshell.Data

/**
 * Created by fyi2 on 1/30/18.
 */
class Action() {
    var id: Int? = null
    var status:Int? = null
    var action:String? = null

    constructor(id:Int, action: String, status:Int): this(){
        this.id = id
        this.action = action
        this.status = status
    }

}