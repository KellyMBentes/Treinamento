package com.example.kotlin.mvpexercice

class SubscriptionFormPresenter(val subscriptionFormView: SubscriptionFormView, val nameValidator: NameValidator,
                                val cpfValidator: CPFValidator, val emailValidator: EmailValidator) {

    fun userNameChanged(name : String) {
        if (!nameValidator.validate(name)) {
            subscriptionFormView.onNameInvalid()
        }
    }

    fun userCPFChanged(cpf : String) {
        if (!cpfValidator.validate(cpf)) {
            subscriptionFormView.onCPFInvalid()
        } else {
            subscriptionFormView.onReadyToValidate()
        }
    }

    fun userEmailChanged(email : String) {
        if (!emailValidator.validate(email)) {
            subscriptionFormView.onEmailInvalid()
        }
    }

    fun performValidation() {

    }
}