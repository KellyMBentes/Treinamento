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
        val input = "192164234329"
        Assertions.assertThat(cpfValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject a cpf smaller than 11` (){
        val input = "1921642343"
        Assertions.assertThat(cpfValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject a cpf whith a invalid tenth digit` (){
        val input = "93595603259"
        Assertions.assertThat(cpfValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject a cpf whith a invalid eleventh digit` (){
        val input = "93595603240"
        Assertions.assertThat(cpfValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject a cpf in the blacklist` (){
        val input = "00000000000"
        Assertions.assertThat(cpfValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should accept a valid cpf` (){
        val input = "93595603249"
        Assertions.assertThat(cpfValidator.validate(input)).isEqualTo(ACCEPT)
    }
}