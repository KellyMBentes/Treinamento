package com.example.recycler.myrecyclerview.logic

import com.example.recycler.myrecyclerview.data.DataSourceInterface
import com.example.recycler.myrecyclerview.data.ListItem
import com.example.recycler.myrecyclerview.view.ViewInterface

/**
 * Created by kellybentes on 16/01/18.
 */

class Controller(private val view: ViewInterface, private val dataSource: DataSourceInterface) {

    fun getListFromDataSource() {

        view.setUpAdapterAndView(
                dataSource.getListOfData()
        )

    }

    fun onListItemClick(testItem: ListItem) {
        view.startDetailActivity(
                testItem.dateAndTime!!,
                testItem.message!!,
                testItem.colorResource
        )
    }
}
