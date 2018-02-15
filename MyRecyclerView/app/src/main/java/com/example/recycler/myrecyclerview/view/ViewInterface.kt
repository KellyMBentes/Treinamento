package com.example.recycler.myrecyclerview.view

import com.example.recycler.myrecyclerview.data.ListItem

/**
 * Created by kellybentes on 16/01/18.
 */

interface ViewInterface {

    fun startDetailActivity(dateAndTime: String, message: String, colorResource: Int)
    fun setUpAdapterAndView(listOfData: List<ListItem>)
}
