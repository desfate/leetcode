package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity414 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var array = IntArray(3)
        array[0] = 1
        array[1] = 2
        array[2] = -2147483648
        thirdMax(array)
    }


    fun thirdMax(nums: IntArray): Int {
        var first: Int? = null
        var second: Int? = null
        var third: Int? = null
        // 先快排
        val list = sortFast(nums.toMutableList())
        list.forEachIndexed { index, i ->
            if(index == 0) first = i
            if(first != null && i != first && second == null){
                second = i
            }
            if(second != null && i != second && third == null){
                third = i
            }
        }
        if(second == null || third == null) return first!!
        return third!!
    }

    fun sortFast(nums: MutableList<Int>): MutableList<Int>{
        if(nums.isEmpty() || nums.size == 1){
            return nums
        }

        val mid = nums[0]
        nums.removeAt(0)

        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()

        nums.forEach {
            if(it <= mid){
                right.add(it)
            }else{
                left.add(it)
            }
        }

        val leftArray = sortFast(left)
        val rightArray = sortFast(right)

        val result = mutableListOf<Int>()
        result.addAll(leftArray)
        result.add(mid)
        result.addAll(rightArray)
        return result

    }



//    fun thirdMax(nums: IntArray): Int {
//        // 通过Long来找到最小值
//        val array = LongArray(3)
//        array[0] = -2147483649
//        array[1] = -2147483649
//        array[2] = -2147483649
//
//        nums.forEach {
//            when{
//                it > array[0] -> {
//                    array[2] = array[1]
//                    array[1] = array[0]
//                    array[0] = it.toLong()
//                }
//
//                it > array[1] && it < array[0] -> {
//                    array[2] = array[1]
//                    array[1] = it.toLong()
//                }
//
//                it > array[2] && it < array[1] -> {
//                    array[2] = it.toLong()
//                }
//            }
//        }
//
//        if (array[2] == -2147483649 || array[1] == -2147483649) {
//            return array[0].toInt()
//        } else {
//            return array[2].toInt()
//        }
//    }


//    fun thirdMax(nums: IntArray): Int {
//        // 简单的冒泡(冒泡会有个问题  就是如果用冒泡法  会有重复数字 重复数字需要合并)
//        // 只需要执行三次
//        for(index in 0..2){
//            nums.forEachIndexed { index, i ->
//                if(index < nums.size - 1){
//                    swap(nums, index, index + 1)
//                }
//            }
//        }
//        if(nums.size < 3){
//            return nums[0]
//        }else{
//            return nums[2]
//        }
//    }
//
//    fun swap(nums: IntArray, start: Int, end: Int){
//        if(end <= nums.size - 1 ){
//            if(nums[start] < nums[end]){
//                val mid = nums[start]
//                nums[start] = nums[end]
//                nums[end] = mid
//            }else if(nums[start]  == nums[end]){
//                nums[end] = -2147483647
//            }
//        }
//    }
}

//

