package com.example.kotlin.mvpexercice

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtName = edt_name
        val edtEmail = edt_email
        val edtCpf = edt_cpf
        val btnConfirm = btn_confirm

        btnConfirm.setOnClickListener({
            val test = Person(
                    edtName.text.toString(),
                    edtEmail.text.toString(),
                    edtCpf.text.toString()
            )
            toast("Clicked $test")
        })
    }

    fun Context.toast(message: CharSequence) =
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
