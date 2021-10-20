package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity453 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intArray = IntArray(3)
        intArray[0] = 1
        intArray[1] = 2
        intArray[2] = 3
        minMoves(intArray)
    }

    fun minMoves(nums: IntArray): Int {
        // 找到最小值
        val min : Int = nums.minOrNull()!!
        var results = 0
        if(min != null){
            nums.forEach {
                results += it - min
            }
        }
        return results
    }


//    // 复制操作流程
//    var max: Int = -1000000001
//    var maxIndex = -1
//    fun minMoves(nums: IntArray): Int {
//        var results = 0
//        while(!checkSameAndFindMax(nums)){
//            nums.forEachIndexed { index, i ->
//                if(index != maxIndex){
//                    nums[index] ++
//                }
//            }
//            results ++
//        }
//        return results
//    }
//
//    fun checkSameAndFindMax(nums: IntArray): Boolean{
//        val same = nums[0]
//        var isSame = true
//        nums.forEachIndexed { index, i ->
//            if(max < i){
//                max = i
//                maxIndex = index
//            }
//            if(same != i) isSame = false
//        }
//        return isSame
//    }






}

