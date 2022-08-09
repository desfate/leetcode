package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.math.absoluteValue

class MainActivity593 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lists = arrayOf("zxcvbnm")
    }

    fun validSquare(p1: IntArray, p2: IntArray, p3: IntArray, p4: IntArray): Boolean {
        // 四个点  3 3 之间 积为 -1
        return getX(p1, p2, p3) && getX(p2, p3, p4) && getX(p3, p4, p1) && getX(p4, p1, p2)
    }

    fun getX(p1: IntArray, p2: IntArray, p3: IntArray): Boolean {
        // k p1 p2 和 k p1 p3 的乘积为 -1
        if(p1[0] - p2[0] == 0){
            return p2[1] - p3[1] == 0 && p2[0] - p3[0] != 0
        }
        if(p2[0] - p3[0] == 0){
            return p1[1] - p2[1] == 0 && p1[0] - p2[0] != 0
        }
        val k1 = (p1[1] - p2[1]) / (p1[0] - p2[0])
        val k2 = (p2[1] - p3[1]) / (p2[0] - p3[0])
        return k1 * k2 == -1
    }

}

