package com.example.kotlin.mvpexercice

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SubscriptionFormPresenterUnitTest {

    @Mock
    private lateinit var subscriptionFormView: SubscriptionFormView
    private lateinit var subscriptionFormPresenter: SubscriptionFormPresenter

    @Before
    fun `before each test` (){
        subscriptionFormPresenter = SubscriptionFormPresenter(subscriptionFormView, NameValidator(), CPFValidator(), EmailValidator())
    }

    @Test
    fun `should call name invalid when the changed name is invalid` (){
        subscriptionFormPresenter.userNameChanged("")

        Mockito.verify(subscriptionFormView).onNameInvalid()
    }

    @Test
    fun `should call cpf invalid when the changed cpf is invalid` (){
        subscriptionFormPresenter.userCPFChanged("")

        Mockito.verify(subscriptionFormView).onCPFInvalid()
    }

    @Test
    fun `should call email invalid when the changed email is invalid` (){
        subscriptionFormPresenter.userEmailChanged("")

        Mockito.verify(subscriptionFormView).onEmailInvalid()
    }
}