package com.example.kotlin.mvpexercice

import android.text.Editable

class TextWatcherFactory {
    fun create( afterTextChange : (userInput : CharSequence?) -> Unit) : android.text.TextWatcher  {
        return object : android.text.TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable : Editable?) = afterTextChange(editable)

        }
    }
}