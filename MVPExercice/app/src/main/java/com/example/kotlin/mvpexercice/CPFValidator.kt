package com.example.kotlin.mvpexercice

/**
 * Created by kellybentes on 14/02/18.
 */

class CPFValidator (){

    val cpfBlacklist = listOf("000.000.000-00")

    fun validate (cpf : String) : Boolean {

        if (cpf.isEmpty()) return false

        val cpfClean = cpf.replace(".", "").replace("-", "")

        lateinit var cpfDigits : IntArray

        if (cpfClean.length != 11) return false

        try {
            cpfClean.toLong()
            cpfDigits = convertCPFStringToIntArray(cpfClean)
        }catch (e : Exception){
            return false
        }

        if (!validateTenthDigit(cpfDigits)) return false

        if (!validateEleventhDigit(cpfDigits)) return false

        if (cpfBlacklist.contains(cpf)) return false

        return true
    }

    private fun convertCPFStringToIntArray (cpfClean : String) : IntArray{
        val cpfIntArray = IntArray(11)

        for (i in 1..11){
            cpfIntArray[i-1] = cpfClean.substring(i-1, i).toInt()
        }

        return cpfIntArray
    }

    private fun validateTenthDigit (cpfDigits: IntArray) : Boolean {
        val sumProductNineFirstDigits = IntArray(9)

        var weight = 10

        for (i in 0..8){
            sumProductNineFirstDigits[i] = cpfDigits[i] * weight
            weight--
        }

        var dvForTenthDigit = sumProductNineFirstDigits.sum() % 11
        dvForTenthDigit = 11 - dvForTenthDigit

        if(dvForTenthDigit > 9)
            dvForTenthDigit = 0

        if (dvForTenthDigit != cpfDigits[9])
            return false

        return true
    }

    private fun validateEleventhDigit (cpfDigits: IntArray) : Boolean {

        val sumProductTenFirstDigits = IntArray(10)

        var weight = 11

        for (i in 0..9){
            sumProductTenFirstDigits[i] = cpfDigits[i] * weight
            weight--
        }

        var dvForeleventhDigit = sumProductTenFirstDigits.sum() % 11
        dvForeleventhDigit = 11 - dvForeleventhDigit

        if(dvForeleventhDigit > 9)
            dvForeleventhDigit = 0

        if (dvForeleventhDigit != cpfDigits[10])
            return false

        return true
    }
}