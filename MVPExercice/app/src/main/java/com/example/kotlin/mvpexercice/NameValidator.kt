package com.example.kotlin.mvpexercice

/**
 * Created by kellybentes on 14/02/18.
 */

class NameValidator (){

    fun validate (name : String) : Boolean {
        if (!name.contains(" ")){
            return false
        } else if (name.length < 4){
            return false
        } else if (name.length > 60){
            return false
        }

        return true
    }
}