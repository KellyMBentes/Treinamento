package com.example.kotlin.mvpexercice

class Presenter (val view: View, val nameValidator: NameValidator,
                 val cpfValidator: CPFValidator, val emailValidator: EmailValidator) {

    fun userNameChanged(name : String) {
        if (!nameValidator.validate(name)) {
            view.onNameInvalid()
        }
    }

    fun userCPFChanged(cpf : String) {
        if (!cpfValidator.validate(cpf)) {
            view.onCPFInvalid()
        } else {
            view.onReadyToValidate()
        }
    }

    fun userEmailChanged(email : String) {
        if (!emailValidator.validate(email)) {
            view.onEmailInvalid()
        }
    }

    fun performValidation() {

    }
}