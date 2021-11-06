package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.math.absoluteValue
import kotlin.math.max

class MainActivity268 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

//    fun missingNumber(nums: IntArray): Int {
//        nums.sort()
//        nums.forEachIndexed { index, i ->
//            if(index != i) return index
//        }
//        return nums.size
//    }
//
//    fun missingNumber(nums: IntArray): Int {
//        var result = 0
//        nums.forEach { result = result.xor(it) }
//        for(index in 0..nums.size){
//            result = result.xor(index)
//        }
//        return result
//    }
//
//    fun missingNumber(nums: IntArray): Int {
//        var sum = 0
//        nums.forEach {
//            sum += it
//        }
//       return ((0 + nums.size) * (nums.size + 1) / 2) - sum
//    }


}

