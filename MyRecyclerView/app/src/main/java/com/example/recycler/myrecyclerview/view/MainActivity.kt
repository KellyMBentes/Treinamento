package com.example.recycler.myrecyclerview.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.recycler.myrecyclerview.R
import com.example.recycler.myrecyclerview.data.FakeDataSource
import com.example.recycler.myrecyclerview.data.ListItem
import com.example.recycler.myrecyclerview.logic.Controller

import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), ViewInterface {

    private var listOfData: List<ListItem>? = null

    private var layoutInflater: LayoutInflater? = null
    private var recyclerView: RecyclerView? = null
    private var adapter: CustomAdapter? = null

    private var controller: Controller? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<View>(R.id.rec_list_activity) as RecyclerView
        layoutInflater = getLayoutInflater()

        controller = Controller(this, FakeDataSource())
    }

    override fun startDetailActivity(dateAndTime: String, message: String, colorResource: Int) {
        val i = Intent(this, DetailActivity::class.java)
        i.putExtra(EXTRA_DATE_AND_TIME, dateAndTime)
        i.putExtra(EXTRA_MESSAGE, message)
        i.putExtra(EXTRA_COLOUR, colorResource)

        startActivity(i)
    }

    fun setUpAdapterAndView(listOfData: List<ListItem>) {
        this.listOfData = listOfData
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        adapter = CustomAdapter()
        recyclerView!!.adapter = adapter
    }

    private inner class CustomAdapter : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

            val v = layoutInflater!!.inflate(R.layout.item_data, parent, false)

            return CustomViewHolder(v)
        }

        override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
            val currentItem = listOfData!![position]

            holder.coloredCircle.setBackgroundResource(
                    currentItem.colorResource
            )

            holder.message.text = currentItem.message

            holder.dateAndTime.text = currentItem.dateAndTime
        }

        override fun getItemCount(): Int {
            return listOfData!!.size
        }

        internal inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

            private val coloredCircle: View
            private val dateAndTime: TextView
            private val message: TextView
            private val container: ViewGroup

            init {

                this.coloredCircle = itemView.findViewById(R.id.imv_list_item_circle)
                this.dateAndTime = itemView.findViewById<View>(R.id.lbl_date_and_time) as TextView
                this.message = itemView.findViewById<View>(R.id.lbl_message) as TextView
                this.container = itemView.findViewById<View>(R.id.root_list_item) as ViewGroup

                this.container.setOnClickListener(this)
            }

            override fun onClick(view: View) {
                val listItem = listOfData!![this.adapterPosition]

                controller!!.onListItemClick(
                        listItem
                )
            }
        }
    }

    companion object {

        private val EXTRA_DATE_AND_TIME = "EXTRA_DATE_AND_TIME"
        private val EXTRA_MESSAGE = "EXTRA_MESSAGE"
        private val EXTRA_COLOUR = "EXTRA_COLOUR"
    }
}
