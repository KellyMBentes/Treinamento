package com.example.recycler.myrecyclerview.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.example.recycler.myrecyclerview.R
import com.example.recycler.myrecyclerview.data.FakeDataSource
import com.example.recycler.myrecyclerview.data.ListItem
import com.example.recycler.myrecyclerview.logic.Controller
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ViewInterface {

    var controller : Controller? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        controller = Controller(this, FakeDataSource())
        controller?.getListFromDataSource()
    }

    override fun startDetailActivity(dateAndTime: String, message: String, colorResource: Int) {

        startActivity(Intent(this, DetailActivity::class.java).apply {
            putExtra(EXTRA_DATE_AND_TIME, dateAndTime)
            putExtra(EXTRA_MESSAGE, message)
            putExtra(EXTRA_COLOUR, colorResource)
        })
    }

    override fun setUpAdapterAndView(listOfData: List<ListItem>) {

        rec_list_activity.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        controller?.apply {
            val customAdapter : CustomAdapter = CustomAdapter(listOfData, controller)
            rec_list_activity.adapter = customAdapter
        }

    }

    companion object {

        private val EXTRA_DATE_AND_TIME = "EXTRA_DATE_AND_TIME"
        private val EXTRA_MESSAGE = "EXTRA_MESSAGE"
        private val EXTRA_COLOUR = "EXTRA_COLOUR"
    }
}
