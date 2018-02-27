package com.example.kotlin.mvpexercice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SubscriptionFormView {

    private lateinit var subscriptionFormPresenter: SubscriptionFormPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        subscriptionFormPresenter = SubscriptionFormPresenter(this, NameValidator(), CPFValidator(), EmailValidator())

        edtName.addTextChangedListener(TextWatcherFactory()
                .create{ subscriptionFormPresenter.userNameChanged(edtName.text.toString())})
        edtCpf.addTextChangedListener(TextWatcherFactory()
                .create{ subscriptionFormPresenter.userCPFChanged(edtCpf.text.toString())})
        edtEmail.addTextChangedListener(TextWatcherFactory()
                .create{ subscriptionFormPresenter.userEmailChanged(edtEmail.text.toString())})

        btnConfirm.setOnClickListener{ subscriptionFormPresenter.performValidation()}
    }

    override fun onNameInvalid() {
        edtName.error = getString(R.string.error_name_invalid)
    }

    override fun onCPFInvalid() {
        edtCpf.error = getString(R.string.error_cpf_invalid)
    }

    override fun onEmailInvalid() {
        edtEmail.error = getString(R.string.error_email_invalid)
    }

    override fun onReadyToValidate() {
        if (!edtName.text.toString().isEmpty() &&
                !edtEmail.text.toString().isEmpty() &&
                !edtCpf.text.toString().isEmpty()) {

            btnConfirm.isClickable = true
            btnConfirm.setTextColor(resources.getColor(android.R.color.black))
        }
    }

    override fun notReadyToValidate() {
        btnConfirm.isClickable = false
        btnConfirm.setTextColor(resources.getColor(android.R.color.darker_gray))
    }

    override fun showValidationDialog() {
        val simpleAlert = AlertDialog.Builder(this@MainActivity).create()
        simpleAlert.setTitle("Alert")

        simpleAlert.setButton(AlertDialog.BUTTON_POSITIVE,
                getString(android.R.string.ok), {
            dialogInterface, i ->
            edtCpf.text.clear()
            edtName.text.clear()
            edtEmail.text.clear()
        })

        simpleAlert.show()
    }
}
