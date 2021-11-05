package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.math.absoluteValue

class MainActivity367 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun isPerfectSquare(num: Int): Boolean {
        var max = num / 2
        if(num == 1) max = 1
        val min = 1
        for(index in min..max){
            if(index * index == num) return true
        }
        return false
    }

}

