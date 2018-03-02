package com.example.kotlin.mvpexercice

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test

class SubscriptionFormPresenterUnitTest {

    private lateinit var subscriptionFormView: SubscriptionFormView
    private lateinit var subscriptionFormPresenter: SubscriptionFormPresenter

    @Before
    fun `before each test` (){
        subscriptionFormView = mock()
        subscriptionFormPresenter = SubscriptionFormPresenter(subscriptionFormView, NameValidator(), CPFValidator(), EmailValidator())
    }

    @Test
    fun `should call name invalid when the changed name is invalid` (){
        subscriptionFormPresenter.userNameChanged("")

        verify(subscriptionFormView).onNameInvalid()
        verify(subscriptionFormView).notReadyToValidate()
    }

    @Test
    fun `should call cpf invalid when the changed cpf is invalid` (){
        subscriptionFormPresenter.userCPFChanged("")

        verify(subscriptionFormView).onCPFInvalid()
        verify(subscriptionFormView).notReadyToValidate()
    }

    @Test
    fun `should call email invalid when the changed email is invalid` (){
        subscriptionFormPresenter.userEmailChanged("")

        verify(subscriptionFormView).onEmailInvalid()
        verify(subscriptionFormView).notReadyToValidate()
    }

    @Test
    fun `should call validation dialog when perform validation` (){
        subscriptionFormPresenter.performValidation()

        verify(subscriptionFormView).showValidationDialog()
    }
}