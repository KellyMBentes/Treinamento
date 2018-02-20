package com.example.kotlin.mvpexercice

import org.assertj.core.api.Assertions
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by kellybentes on 20/02/18.
 */
@RunWith(MockitoJUnitRunner::class)
class CPFValidatorUnitTest {

    lateinit var cpfValidator : CPFValidator
    val REJECT = false
    val ACCEPT = true

    @Before
    fun `before each test` (){
        cpfValidator = CPFValidator()
    }

    @Test
    fun `should reject a empty string` (){
        val input = ""
        Assertions.assertThat(cpfValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject a cpf bigger than 11` (){
        val input = "192.164.234-329"
        Assertions.assertThat(cpfValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject a cpf smaller than 11` (){
        val input = "192.164.234-3"
        Assertions.assertThat(cpfValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject a cpf that is not a number` (){
        val input = "abc.def.ghi-jk"
        Assertions.assertThat(cpfValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject a cpf whith a invalid tenth digit` (){
        val input = "935.956.032-59"
        Assertions.assertThat(cpfValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject a cpf whith a invalid eleventh digit` (){
        val input = "935.956.032-40"
        Assertions.assertThat(cpfValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject a cpf in the blacklist` (){
        val input = "000.000.000-00"
        Assertions.assertThat(cpfValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should accept a valid cpf` (){
        val input = "935.956.032-49"
        Assertions.assertThat(cpfValidator.validate(input)).isEqualTo(ACCEPT)
    }
}