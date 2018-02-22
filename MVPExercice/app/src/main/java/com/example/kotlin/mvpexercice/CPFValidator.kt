package com.example.kotlin.mvpexercice

/**
 * Created by kellybentes on 14/02/18.
 */

class CPFValidator (){

    private val cpfBlacklist = listOf("00000000000", "11111111111", "22222222222", "33333333333",
            "44444444444", "55555555555", "66666666666","77777777777", "88888888888", "99999999999")

    fun validate (cpf : String) : Boolean {

        if (cpf.isEmpty()) return false

        if (cpf.length != 11) return false

        if (!validateDigit(cpf, 10)) return false

        if (!validateDigit(cpf, 11)) return false

        if (cpfBlacklist.contains(cpf)) return false

        return true
    }

    private fun convertCPFStringToIntArray (cpf : String) : IntArray{
        val cpfIntArray = IntArray(11)

        for (i in 1..11){
            cpfIntArray[i-1] = cpf.substring(i-1, i).toInt()
        }

        return cpfIntArray
    }

    private fun validateDigit (cpf: String, digitNumber: Int) : Boolean {
        val cpfDigits = convertCPFStringToIntArray(cpf)
        val sumProductDigits = IntArray(digitNumber-1)

        var weight = digitNumber

        for (i in 0..(sumProductDigits.size - 1)){
            sumProductDigits[i] = cpfDigits[i] * weight
            weight--
        }

        var dvForDigit = sumProductDigits.sum() % 11
        dvForDigit = 11 - dvForDigit

        if(dvForDigit > 9)
            dvForDigit = 0

        return (dvForDigit == cpfDigits[digitNumber-1])
    }
}