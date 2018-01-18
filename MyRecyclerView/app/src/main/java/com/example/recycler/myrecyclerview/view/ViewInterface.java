package com.example.recycler.myrecyclerview.view;

import com.example.recycler.myrecyclerview.data.ListItem;

import java.util.List;

/**
 * Created by kellybentes on 16/01/18.
 */

public interface ViewInterface {

    void startDetailActivity (String dateAndTime, String message, int colorResource);
    void setUpAdapterAndView (List<ListItem> listOfData);
}
