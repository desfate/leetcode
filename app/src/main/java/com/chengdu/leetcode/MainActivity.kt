package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val array = IntArray(8)
        array[0] = 2
        array[1] = 1
        array[2] = 1
        array[3] = 3
        array[4] = 1
        array[5] = 4
        array[6] = 5
        array[7] = 6
        majorityElement(array)

    }

    fun majorityElement(nums: IntArray): List<Int> {
        // 转换成 hashMap
        val result = arrayListOf<Int>()
        val hashMap = hashMapOf<Int, Int>()
        nums.forEach {
            hashMap[it] = hashMap.getOrDefault(it, 0) + 1
        }
        hashMap.forEach {
            if(it.value > nums.size / 3){
                result.add(it.key)
            }
        }
        return result
    }

//    fun majorityElement(nums: IntArray): List<Int> {
//        // 摩尔投票法
//        // 每次出现三个不同元素则抵消一次
//        // 一遍循环 则O(n) = n
//        var elementValueFirst = 0
//        var elementValueSecond = 0
//
//        var elementTimesFirst = 0
//        var elementTimesSecond = 0
//
//        nums.forEach {
//            if (elementValueFirst == it && elementTimesFirst != 0) {
//                elementTimesFirst++
//            } else if (elementValueSecond == it && elementTimesSecond != 0) {
//                elementTimesSecond++
//            } else if (elementTimesFirst == 0) {
//                elementValueFirst = it
//                elementTimesFirst = 1
//            } else if (elementTimesSecond == 0) {
//                elementValueSecond = it
//                elementTimesSecond = 1
//            } else if (it != elementValueFirst && it != elementValueSecond) {
//                elementTimesFirst--
//                elementTimesSecond--
//            }
//        }
//        val resultList = arrayListOf<Int>()
//        // 这里要要考虑一个问题  如果从头到尾只有两个元素 或者只有一个元素的情况
//        // 所以这里做一次交验 证明一下这个元素是否满足 n/3
//        var firstCount = 0
//        var secondCount = 0
//        nums.forEach {
//            if (it == elementValueFirst) {
//                firstCount++
//            } else if (it == elementValueSecond) {
//                secondCount++
//            }
//        }
//        if (firstCount * 3 > nums.size) {
//            resultList.add(elementValueFirst)
//        }
//        if (secondCount * 3 > nums.size) {
//            resultList.add(elementValueSecond)
//        }
//        // 样处理完  剩余的元素即是答案
//        return resultList
//    }

}

