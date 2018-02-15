package com.example.recycler.myrecyclerview.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.recycler.myrecyclerview.R
import com.example.recycler.myrecyclerview.data.ListItem
import com.example.recycler.myrecyclerview.logic.Controller
import com.example.recycler.myrecyclerview.util.layoutInflater
import kotlinx.android.synthetic.main.item_data.view.*

/**
 * Created by kellybentes on 18/01/18.
 */

class CustomAdapter (private var listOfData : List<ListItem>, private val controller: Controller?)
    : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    override fun getItemCount(): Int {
        return listOfData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val v = parent.context.layoutInflater.inflate(R.layout.item_data, parent, false)
        return CustomViewHolder(v)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val currentItem = listOfData[position]

        holder.coloredCircle.setBackgroundResource(
                currentItem.colorResource
        )
        holder.message.text = currentItem.message
        holder.dateAndTime.text = currentItem.dateAndTime
    }



    inner class CustomViewHolder internal constructor (
            itemView: View) :
            RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val coloredCircle = itemView.imv_list_item_circle
        val dateAndTime = itemView.lbl_date_and_time
        val message = itemView.lbl_message
        val container = itemView.root_list_item

        init {
            this.container.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            val listItem = listOfData[this.adapterPosition]
            if (controller != null) {
                controller.onListItemClick(
                        listItem
                )
            }
        }
    }
}
