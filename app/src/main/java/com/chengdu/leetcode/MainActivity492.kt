package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.sqrt

class MainActivity492 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun constructRectangle(area: Int): IntArray {
        var width = sqrt(area.toDouble()).toInt()
        while (area % width != 0){
            width --
        }
        val array = IntArray(2)
        array[0] = area / width
        array[1] = width
        return array
    }

//    fun constructRectangle(area: Int): IntArray {
//        var height = sqrt(area.toDouble()).toInt()
//        while (area % height != 0){
//            height ++
//        }
//        val array = IntArray(2)
//        array[0] = height
//        array[1] = area / height
//        if(array[0] < array[1]){
//            array.reverse()
//        }
//        return array
//    }
}

