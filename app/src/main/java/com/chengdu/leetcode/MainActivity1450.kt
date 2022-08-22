package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.absoluteValue
import kotlin.math.max
import kotlin.math.min

class MainActivity1450 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun busyStudent(startTime: IntArray, endTime: IntArray, queryTime: Int): Int {
        var num = 0
        endTime.forEachIndexed { index, i -> 
            if(i >= queryTime && startTime[index] <= queryTime){
                num ++
            }
        }
        return  num
    }

}