package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        countSegments("                ")
    }

    fun countSegments(s: String): Int {
        var segmentCount = 0
        s.forEachIndexed { index, c ->
            if((index == 0 || s[index - 1] == ' ') && c != ' '){
                segmentCount ++
            }
        }
        return segmentCount
    }

}

