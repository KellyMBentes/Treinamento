package com.example.kotlin.mvpexercice

interface View {

    fun getUserName () : String
    fun onNameInvalid(resId : Int)
    fun geUserCPF(): String
    fun onCPFInvalid (resId : Int)
    fun getUserEmail(): String
    fun onEmailInvalid(resId: Int)
    fun onReadyToValidate()
}