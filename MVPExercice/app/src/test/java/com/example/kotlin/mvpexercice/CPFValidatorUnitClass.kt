package com.example.kotlin.mvpexercice

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

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
        assertThat(cpfValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject a cpf bigger than 11` (){
        val input = "192164234329"
        assertThat(cpfValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject a cpf smaller than 11` (){
        val input = "1921642343"
        assertThat(cpfValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject a cpf whith a invalid tenth digit` (){
        val input = "93595603259"
        assertThat(cpfValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject a cpf whith a invalid eleventh digit` (){
        val input = "93595603240"
        assertThat(cpfValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject a cpf in the blacklist` (){
        val input = "00000000000"
        assertThat(cpfValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should accept a valid cpf` (){
        val input = "93595603249"
        assertThat(cpfValidator.validate(input)).isEqualTo(ACCEPT)
    }
}