package com.example.kotlin.mvpexercice

interface View {

    fun onNameInvalid()
    fun onCPFInvalid ()
    fun onEmailInvalid()
    fun onReadyToValidate()
}