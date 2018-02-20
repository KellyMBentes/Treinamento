package com.example.kotlin.mvpexercice

/**
 * Created by kellybentes on 20/02/18.
 */
class EmailValidator {

    fun validate(email: String): Boolean {

        if (email.isEmpty()) return false

        val emailPattern = Regex ("^[A-Z,a-z][A-Z,a-z,0-9,.,\\-,_]+[A-Z,a-z,0-9]" +
                "@[A-Z,a-z,0-9]+\\.[A-z,a-z,.]+[A-Z,a-z,0-9]")

        if (!email.matches(emailPattern)) return false

        return true
    }
}