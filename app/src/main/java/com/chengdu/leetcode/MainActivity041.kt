package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.text.StringBuilder

class MainActivity041 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        countAndSay(5)
    }


    class MovingAverage(val size: Int) {

        /** Initialize your data structure here. */
        var list = arrayListOf<Int>()

        fun next(`val`: Int): Double {
            list.add(`val`)
            if(list.size <= size){
                return list.sum().div(list.size.toDouble())
            }else{
                return list.subList(list.size - size, list.size).sum().div(size.toDouble())
            }
        }
    }
}

