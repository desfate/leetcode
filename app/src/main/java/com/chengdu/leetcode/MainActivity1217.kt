package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.math.abs
import kotlin.math.absoluteValue
import kotlin.math.max
import kotlin.math.min

class MainActivity1217 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val array1 = IntArray(18)

        minCostToMoveChips(array1)
    }

    fun minCostToMoveChips(position: IntArray): Int {
        var i = 0
        var j = 0
        position.forEach {
            if(it.and(1) == 0){
                i ++
            }else{
                j ++
            }
        }
        return min(i,j)
    }

}

