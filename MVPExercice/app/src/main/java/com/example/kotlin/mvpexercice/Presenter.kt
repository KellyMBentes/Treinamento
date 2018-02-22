package com.example.kotlin.mvpexercice

class Presenter (val view: View, val nameValidator: NameValidator,
                 val cpfValidator: CPFValidator, val emailValidator: EmailValidator) {

    fun userNameChanged() {
        val name = view.getUserName()
        if (!nameValidator.validate(name)) {
            view.onNameInvalid(R.string.error_name_invalid)
        }
    }

    fun userCPFChanged() {
        val cpf = view.geUserCPF()
        if (!cpfValidator.validate(cpf)) {
            view.onCPFInvalid(R.string.error_cpf_invalid)
        }
    }

    fun userEmailChanged() {
        val email = view.getUserEmail()
        if (!emailValidator.validate(email)) {
            view.onEmailInvalid(R.string.error_email_invalid)
        } else {
            view.onReadyToValidate()
        }
    }

    fun performValidation() {

    }
}