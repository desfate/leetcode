package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.math.absoluteValue
import kotlin.math.max

class MainActivity1252 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val array1 = IntArray(18)

    }

    fun oddCells(m: Int, n: Int, indices: Array<IntArray>): Int {
        // 只需要记录奇偶性质
        val array = BooleanArray(m+n)
        indices.forEach {
            array[it[0]] = !array[it[0]]
            array[it[1] + m] = !array[it[1] + m]
        }
        var result = 0
        for (i in 0 until m){
            for (j in m until n + m){
                if(!(array[i] and array[j])){
                    result ++
                }
            }
        }
        return result;
    }

}

