package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Math.abs
import java.util.*
import kotlin.math.absoluteValue
import kotlin.math.max

class MainActivity1224 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    var max = 0
    val hashMap = hashMapOf<Int, Int>()
    fun maxEqualFreq(nums: IntArray): Int {
        nums.forEachIndexed { index, i ->
            val value = hashMap.getOrDefault(i, 0)
            hashMap[i] = value + 1
            if(isFreq()){
                max = max(max, index + 1)
            }
        }
        return max
    }

    // 判断通过hashmap值合并后是否只有两个值  且两个值的差值 只有1
    fun isFreq(): Boolean {
        val set = hashMap.map {
            it.value
        }.toSet()
        var first = -1
        if (set.size == 2) {
            set.forEach {
                if (first == -1) {
                    first = it
                } else {
                    if(first == 1 || it == 1) return true
                    return kotlin.math.abs(first - it) == 1
                }
            }
        }
        return false
    }


}

