package com.example.recycler.myrecyclerview.view

import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.example.recycler.myrecyclerview.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val i = intent
        val dateAndTimeExtra = i.getStringExtra(EXTRA_DATE_AND_TIME)
        val messageExtra = i.getStringExtra(EXTRA_MESSAGE)
        val colorResourceExtra = i.getIntExtra(EXTRA_COLOUR, 0)

        lbl_date_time_header.text = dateAndTimeExtra
        lbl_message_body.text = messageExtra
        cont_colored_background.setBackgroundColor(
                ContextCompat.getColor(this, colorResourceExtra)
        )
    }

    companion object {

        private val EXTRA_DATE_AND_TIME = "EXTRA_DATE_AND_TIME"
        private val EXTRA_MESSAGE = "EXTRA_MESSAGE"
        private val EXTRA_COLOUR = "EXTRA_COLOUR"
    }
}
