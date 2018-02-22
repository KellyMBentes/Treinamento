package com.example.kotlin.mvpexercice

import android.text.Editable

class TextWatcherFactory {
    fun create( afterTextChange : (p0: CharSequence?) -> Unit) : android.text.TextWatcher  {
        return object : android.text.TextWatcher {
            override fun afterTextChanged(p0: Editable?) = afterTextChange(p0)

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        }
    }
}