package com.example.kotlin.mvpexercice

class SubscriptionFormPresenter(private val subscriptionFormView: SubscriptionFormView, private val nameValidator: NameValidator,
                                private val cpfValidator: CPFValidator, private val emailValidator: EmailValidator) {

    fun userNameChanged(name : String) {
        if (!nameValidator.validate(name)) {
            subscriptionFormView.onNameInvalid()
            subscriptionFormView.notReadyToValidate()
        }
    }

    fun userCPFChanged(cpf : String) {
        if (!cpfValidator.validate(cpf)) {
            subscriptionFormView.onCPFInvalid()
            subscriptionFormView.notReadyToValidate()
        } else {
            subscriptionFormView.onReadyToValidate()
        }
    }

    fun userEmailChanged(email : String) {
        if (!emailValidator.validate(email)) {
            subscriptionFormView.onEmailInvalid()
            subscriptionFormView.notReadyToValidate()
        }
    }

    fun performValidation() {
        subscriptionFormView.showValidationDialog()
    }
}