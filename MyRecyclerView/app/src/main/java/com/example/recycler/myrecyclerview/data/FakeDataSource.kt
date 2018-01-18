package com.example.recycler.myrecyclerview.data

import com.example.recycler.myrecyclerview.R

import java.util.ArrayList
import java.util.Random

/**
 * Test Double
 * (Specifically a "Fake")
 * Created by kellybentes on 15/01/18.
 */

class FakeDataSource : DataSourceInterface {

    private val datesAndTimes = arrayOf("6:30AM 06/01/2017", "9:26PM 04/22/2013", "2:01PM 12/02/2015", "2:43AM 09/7/2018")
    private val messages = arrayOf("Check out content like Fragmented Podcast to expose yourself to the knowledge, ideas, " + "and opinions of experts in your field", "Look at Open Source Projects like Android Architecture Blueprints to see how experts" + " design and build Apps", "Write lots of Code and Example Apps. Writing good Quality Code in an efficient manner " + "is a Skill to be practiced like any other.", "If at first something doesn't make any sense, find another explanation. We all " + "learn/teach different from each other. Find an explanation that speaks to you.")
    private val colours = intArrayOf(R.color.RED, R.color.BLUE, R.color.GREEN, R.color.YELLOW)

    override fun getListOfData(): List<ListItem> {
        val listOfData = ArrayList<ListItem>()

        val random = Random()

        for (i in 0..sizeOfCollection) {

            val randOne = random.nextInt(4)
            val randTwo = random.nextInt(4)
            val randThree = random.nextInt(4)

            val listItem = ListItem(
                    datesAndTimes[randOne],
                    messages[randTwo],
                    colours[randThree]
            )

            listOfData.add(listItem)
        }

        return listOfData

    }

    companion object {

        private val sizeOfCollection = 12
    }
}
