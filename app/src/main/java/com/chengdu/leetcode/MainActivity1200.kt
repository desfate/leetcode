package com.chengdu.leetcode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.math.abs
import kotlin.math.min


/**
给你个整数数组 arr，其中每个元素都 不相同。

请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 */
class MainActivity1200 {
    // 标准方法
    fun minimumAbsDifference2(arr: IntArray): List<List<Int>> {
        val result = arrayListOf<List<Int>>()
        var min = Int.MAX_VALUE
        arr.forEachIndexed { indexi, i ->
            var j = indexi
            while (j < arr.size) {
                if (j != indexi) {
                    val cur = abs(arr[j] - i)
                    if (cur < min) {
                        result.clear()
                    }
                    min = min(min, cur)
                    if (min == cur) {
                        result.add(
                            if (i > arr[j]) {
                                listOf(arr[j], i)
                            } else {
                                listOf(i, arr[j])
                            }
                        )
                    }
                }
                j += 1
            }
        }
        return result.toList().sortedBy { it[0] }
    }

    // 提速
    fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
        val result = arrayListOf<List<Int>>()
        var min = Int.MAX_VALUE
        val arrs = arr.sortedBy { it }
        arrs.forEachIndexed { indexi, i ->
            if(indexi == arrs.size - 1) return result.toList().sortedBy { it[0] }
            val j = indexi + 1
            val cur = arrs[j] - i
            if (cur < min) {
                result.clear()
                result.add(
                    listOf(i, arrs[j])
                )
                min = cur
            }else if(cur == min){
                result.add(
                    listOf(i, arrs[j])
                )
            }
        }
        return result
    }
}

