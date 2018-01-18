package com.example.recycler.myrecyclerview.logic;

import com.example.recycler.myrecyclerview.data.DataSourceInterface;
import com.example.recycler.myrecyclerview.data.ListItem;
import com.example.recycler.myrecyclerview.view.ViewInterface;

/**
 * Created by kellybentes on 16/01/18.
 */

public class Controller {

    private ViewInterface view;
    private DataSourceInterface dataSource;

    public Controller(ViewInterface view, DataSourceInterface dataSource) {
        this.view = view;
        this.dataSource = dataSource;

        getListFromDataSource();
    }

    public void getListFromDataSource() {

        view.setUpAdapterAndView(
                dataSource.getListOfData()
        );

    }

    public void onListItemClick(ListItem testItem) {
        view.startDetailActivity(
                testItem.getDateAndTime(),
                testItem.getMessage(),
                testItem.getColorResource()
        );
    }
}
