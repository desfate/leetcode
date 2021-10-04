package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.absoluteValue
import kotlin.math.max
import kotlin.math.min

class MainActivity223 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        computeArea(-2,-2,2,2,-1,-1,1,1)
    }

    fun computeArea(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int): Int {
        // 将坐标投影到xy轴上  需要减去的c的面积则为交集
        val ASize = (ax2 - ax1) * (ay2 - ay1)
        val BSize = (bx2 - bx1) * (by2 - by1)
        val CSize = max((min(ax2, bx2) - max(ax1, bx1)), 0) * max((min(ay2, by2) - max(ay1, by1)),0)
        return ASize + BSize - CSize


    }



}