package com.example.kotlin.mvpexercice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View {

    private lateinit var presenter : Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = Presenter(this, NameValidator(), CPFValidator(), EmailValidator())

        edtName.addTextChangedListener(TextWatcherFactory()
                .create{presenter.userNameChanged(edtName.text.toString())})
        edtCpf.addTextChangedListener(TextWatcherFactory()
                .create{presenter.userCPFChanged(edtCpf.text.toString())})
        edtEmail.addTextChangedListener(TextWatcherFactory()
                .create{presenter.userEmailChanged(edtEmail.text.toString())})

        btnConfirm.setOnClickListener{presenter.performValidation()}
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
        btnConfirm.isClickable = true
        btnConfirm.setTextColor(resources.getColor(android.R.color.black))
    }
}
