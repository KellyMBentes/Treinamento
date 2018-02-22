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
        presenter.userNameChanged("")

        Mockito.verify(view).onNameInvalid()
    }

    @Test
    fun `should call cpf invalid when the changed cpf is invalid` (){
        presenter.userCPFChanged("")

        Mockito.verify(view).onCPFInvalid()
    }

    @Test
    fun `should call email invalid when the changed email is invalid` (){
        presenter.userEmailChanged("")

        Mockito.verify(view).onEmailInvalid()
    }
}