package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.absoluteValue
import kotlin.math.max
import kotlin.math.min

class MainActivity1656 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    class OrderedStream(n: Int) {
        var map = hashMapOf<Int, String>()
        var index = 0
        fun insert(idKey: Int, value: String): List<String> {
            val result = arrayListOf<String>()
            map[idKey] = value
            while(map.contains(index + 1)){
                result.add(map[index + 1]!!)
                index ++
            }
            return result
        }
    }

}