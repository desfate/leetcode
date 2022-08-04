package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.absoluteValue
import kotlin.math.max
import kotlin.math.min

class MainActivity1403 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun minSubsequence(nums: IntArray): List<Int> {
        if (nums.size == 1) return nums.toList()
        // 先排序  排序之后  双指针 计算
        val list = nums.sortedArray()
        var start = 0
        var end = nums.size - 1
        var sumStart = list[0]
        var sumEnd = list[end]
        while (start != end) {
            if (sumStart >= sumEnd) {
                end--
                sumEnd += list[end]
            } else {
                start++
                sumStart += list[start]
            }
        }
        return list.takeLast(nums.size - end).reversed()
    }
}