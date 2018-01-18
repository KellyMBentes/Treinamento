package com.example.recycler.myrecyclerview.view

import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

import com.example.recycler.myrecyclerview.R

class DetailActivity : AppCompatActivity() {

    private var dateAndTime: TextView? = null
    private var message: TextView? = null
    private var coloredBackground: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val i = intent
        val dateAndTimeExtra = i.getStringExtra(EXTRA_DATE_AND_TIME)
        val messageExtra = i.getStringExtra(EXTRA_MESSAGE)
        val colorResourceExtra = i.getIntExtra(EXTRA_COLOUR, 0)

        dateAndTime = findViewById<View>(R.id.lbl_date_time_header) as TextView
        dateAndTime!!.text = dateAndTimeExtra

        message = findViewById<View>(R.id.lbl_message_body) as TextView
        message!!.text = messageExtra

        coloredBackground = findViewById(R.id.cont_colored_background)
        coloredBackground!!.setBackgroundColor(
                ContextCompat.getColor(this, colorResourceExtra)
        )
    }

    companion object {

        private val EXTRA_DATE_AND_TIME = "EXTRA_DATE_AND_TIME"
        private val EXTRA_MESSAGE = "EXTRA_MESSAGE"
        private val EXTRA_COLOUR = "EXTRA_COLOUR"
    }
}
