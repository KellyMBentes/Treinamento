package com.example.recycler.myrecyclerview

import com.example.recycler.myrecyclerview.data.DataSourceInterface
import com.example.recycler.myrecyclerview.data.ListItem
import com.example.recycler.myrecyclerview.logic.Controller
import com.example.recycler.myrecyclerview.view.ViewInterface

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

import java.util.ArrayList

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(MockitoJUnitRunner::class)
class ControllerUnitTest {

    @Mock
    internal var dataSource: DataSourceInterface? = null

    @Mock
    internal var view: ViewInterface? = null

    internal var controller: Controller? = null

    @Before
    fun setUpTest() {
        MockitoAnnotations.initMocks(this)
        controller = Controller(view!!, dataSource!!)
    }

    @Test
    fun onGetListDataSuccessful() {
        val listOfData = ArrayList<ListItem>()
        listOfData.add(testItem)

        Mockito.`when`(dataSource!!.listOfData).thenReturn(listOfData)

        controller?.getListFromDataSource()

        Mockito.verify<ViewInterface>(view).setUpAdapterAndView(listOfData)
    }

    @Test
    fun onListItemClicked() {
        controller?.onListItemClick(testItem)

        Mockito.verify<ViewInterface>(view).startDetailActivity(
                testItem.dateAndTime!!,
                testItem.message!!,
                testItem.colorResource)
    }

    companion object {

        private val testItem = ListItem(
                "6:30AM 06/01/2017",
                "Check out content like Fragmented Podcast to expose yourself to the knowledge, ideas, " + "and opinions of experts in your field",
                R.color.RED
        )
    }
}