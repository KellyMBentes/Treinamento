package com.example.recycler.myrecyclerview;

import com.example.recycler.myrecyclerview.data.DataSourceInterface;
import com.example.recycler.myrecyclerview.data.ListItem;
import com.example.recycler.myrecyclerview.logic.Controller;
import com.example.recycler.myrecyclerview.view.ViewInterface;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ControllerUnitTest {

    @Mock
    DataSourceInterface dataSource;

    @Mock
    ViewInterface view;

    Controller controller;

    private  static final ListItem testItem = new ListItem(
            "6:30AM 06/01/2017",
            "Check out content like Fragmented Podcast to expose yourself to the knowledge, ideas, " +
                    "and opinions of experts in your field",
            R.color.RED
    );

    @Before
    public void setUpTest (){
        MockitoAnnotations.initMocks(this);
        controller = new Controller(view, dataSource);
    }

    @Test
    public void onGetListDataSuccessful() {
        ArrayList<ListItem> listOfData = new ArrayList<>();
        listOfData.add(testItem);

        Mockito.when(dataSource.getListOfData()).thenReturn(listOfData);

        controller.getListFromDataSource();

        Mockito.verify(view).setUpAdapterAndView(listOfData);
    }

    @Test
    public void onListItemClicked() {
        controller.onListItemClick(testItem);

        Mockito.verify(view).startDetailActivity(
                testItem.getDateAndTime(),
                testItem.getMessage(),
                testItem.getColorResource());
    }
}