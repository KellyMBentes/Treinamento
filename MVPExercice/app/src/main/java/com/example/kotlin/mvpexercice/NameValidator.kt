package com.example.kotlin.mvpexercice

/**
 * Created by kellybentes on 14/02/18.
 */

class NameValidator (){

    fun validate (name : String) : Boolean {

        val nameAndLastNamePattern = Regex ("\\w+ \\w+")

        if (name.isEmpty()) return false
        if (!name.matches(nameAndLastNamePattern)) return false
        if (name.length < 4) return false
        if (name.length > 60) return false

        return true
    }
}