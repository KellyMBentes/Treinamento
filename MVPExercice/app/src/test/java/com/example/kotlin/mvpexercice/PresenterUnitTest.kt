package com.example.kotlin.mvpexercice

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PresenterUnitTest {

    @Mock
    private lateinit var view: View
    private lateinit var presenter: Presenter

    @Before
    fun `before each test` (){
        presenter = Presenter(view, NameValidator(), CPFValidator(), EmailValidator())
    }

    @Test
    fun `should call name invalid when the changed name is invalid` (){
        Mockito.`when`(view.getUserName()).thenReturn("")
        presenter.userNameChanged()

        Mockito.verify(view).onNameInvalid(R.string.error_name_invalid)
    }

    @Test
    fun `should call cpf invalid when the changed cpf is invalid` (){
        Mockito.`when`(view.geUserCPF()).thenReturn("")
        presenter.userCPFChanged()

        Mockito.verify(view).onCPFInvalid(R.string.error_cpf_invalid)
    }

    @Test
    fun `should call email invalid when the changed email is invalid` (){
        Mockito.`when`(view.getUserEmail()).thenReturn("")
        presenter.userEmailChanged()

        Mockito.verify(view).onEmailInvalid(R.string.error_email_invalid)
    }
}