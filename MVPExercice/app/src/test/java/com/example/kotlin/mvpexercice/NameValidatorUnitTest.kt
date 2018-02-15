package com.example.kotlin.mvpexercice

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
/**
 * Created by kellybentes on 14/02/18.
 */
@RunWith(MockitoJUnitRunner::class)
class NameValidatorUnitTest {

    lateinit var nameValidator : NameValidator
    val REJECT = false
    val ACCEPT = true

    @Before
    fun `before each test` (){
        nameValidator = NameValidator()
    }

    @Test
    fun `should reject a empty string` (){
        val input = ""
        val output = nameValidator.validate(input)
        assertEquals(REJECT, output)
    }

    @Test
    fun `should reject name without last name` (){
        val input = "Kelly "
        val output = nameValidator.validate(input)
        assertEquals(REJECT, output)
    }

    @Test
    fun `should reject last name without name` (){
        val input = " Tavares"
        val output = nameValidator.validate(input)
        assertEquals(REJECT, output)
    }

    @Test
    fun `should reject to short names` (){
        val input = "K T"
        val output = nameValidator.validate(input)
        assertEquals(REJECT, output)
    }

    @Test
    fun `should reject to long names` (){
        val input = buildString {
            append("abc ")
            for (i in 1..57) append("a")
        }
        val output = nameValidator.validate(input)
        assertEquals(REJECT, output)
    }

    @Test
    fun `should accept a valid name` (){
        val input = "Kelly Tavares"
        val output = nameValidator.validate(input)
        assertEquals(ACCEPT, output)
    }
}