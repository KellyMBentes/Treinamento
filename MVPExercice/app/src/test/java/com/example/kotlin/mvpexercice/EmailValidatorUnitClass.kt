package com.example.kotlin.mvpexercice

import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by kellybentes on 20/02/18.
 */

class EmailValidatorUnitClass {

    lateinit var emailValidator: EmailValidator
    val REJECT = false
    val ACCEPT = true

    @Before
    fun `before each test` (){
        emailValidator = EmailValidator()
    }

    @Test
    fun `should reject email with characters other than hyphens, underscores, dots, numbers, letters and @` (){
        val input = "kell(y@mail.com"
        Assertions.assertThat(emailValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject a empty string` (){
        val input = ""
        Assertions.assertThat(emailValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject email with hyphens in the start` (){
        val input = "-kelly@mail.com"
        Assertions.assertThat(emailValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject email with underscores in the start` (){
        val input = "_kelly@mail.com"
        Assertions.assertThat(emailValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject email with dot in the start` (){
        val input = ".kelly@mail.com"
        Assertions.assertThat(emailValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject email with numbers in the start` (){
        val input = "0kelly@mail.com"
        Assertions.assertThat(emailValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject email with hyphens right before @` (){
        val input = "kelly-@mail.com"
        Assertions.assertThat(emailValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject email with underscores right before @` (){
        val input = "kelly_@mail.com"
        Assertions.assertThat(emailValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject email with dot right before @` (){
        val input = "kelly.@mail.com"
        Assertions.assertThat(emailValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject email with hyphens right after @` (){
        val input = "kelly@-mail.com"
        Assertions.assertThat(emailValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject email with underscores right after @` (){
        val input = "kelly@_mail.com"
        Assertions.assertThat(emailValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject email with dot right after @` (){
        val input = "kelly@.mail.com"
        Assertions.assertThat(emailValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject email without dot after @` (){
        val input = "kelly@mail"
        Assertions.assertThat(emailValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject email with hyphens in the end` (){
        val input = "kelly@mail.com-"
        Assertions.assertThat(emailValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject email with underscores in the end` (){
        val input = "kelly@mail.com_"
        Assertions.assertThat(emailValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should reject email with dot in the end` (){
        val input = "kelly@mail.com."
        Assertions.assertThat(emailValidator.validate(input)).isEqualTo(REJECT)
    }

    @Test
    fun `should accept a valid email` (){
        val input = "kellymaria.bentes_24-3@mail.com.br"
        Assertions.assertThat(emailValidator.validate(input)).isEqualTo(ACCEPT)
    }
}