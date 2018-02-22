package com.example.kotlin.mvpexercice

interface SubscriptionFormView {

    fun onNameInvalid()
    fun onCPFInvalid ()
    fun onEmailInvalid()
    fun onReadyToValidate()
}