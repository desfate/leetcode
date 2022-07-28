package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity1331 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val array1 = IntArray(18)

    }

    fun arrayRankTransform(arr: IntArray): IntArray {
        val sortedList = arr.toSortedSet().toIntArray()
        return arr.map {
            sortedList.indexOf(it) + 1
        }.toIntArray()
    }

}

