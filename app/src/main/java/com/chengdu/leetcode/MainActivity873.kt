package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.absoluteValue

class MainActivity873 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun lenLongestFibSubseq(arr: IntArray): Int {
        return 0
    }


    fun getLength(arr: IntArray, start: Int, next: Int): Int{
        if(start < arr.size && next < arr.size){
            val value = arr[start] - arr[next]
            var valueIndex = -1
            arr.forEachIndexed { index, i ->
                if(i == value){
                    valueIndex = index
                }
            }
            if(valueIndex != -1){
                for(i in valueIndex + 1..arr.size){
                    getLength(arr, valueIndex, valueIndex + i)
                }

            }
        }
        return 0
    }

}

