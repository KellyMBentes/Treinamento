package com.example.kotlin.mvpexercice

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
/**
 * Created by kellybentes on 14/02/18.
 */
@RunWith(MockitoJUnitRunner::class)
class NameValidatorUnitTest {

    var nameValidator : NameValidator? = null

    @Before
    fun setUpTest(){
        MockitoAnnotations.initMocks(this)
        nameValidator = NameValidator()
    }

    @Test
    fun onNameWitoutLastName (){
        val test = "Kelly"
        val expected = false
        val output = nameValidator!!.validate(test)
        assertEquals(expected, output)
    }

    @Test
    fun onNameToShort (){
        val test = "K T"
        val expected = false
        val output = nameValidator!!.validate(test)
        assertEquals(expected, output)
    }

    @Test
    fun onNameToLong (){
        val test = buildString {
            append("abc ")
            for (i in 1..57) append("a")
        }
        val expected = false
        val output = nameValidator!!.validate(test)
        assertEquals(expected, output)
    }

    @Test
    fun onValidName (){
        val test = "Kelly Tavares"
        val expected = true
        val output = nameValidator!!.validate(test)
        assertEquals(expected, output)
    }
}