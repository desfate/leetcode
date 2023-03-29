package com.chengdu.leetcode.classify.mathematics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chengdu.leetcode.R

class MainActivity69 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val array: IntArray = IntArray(4)

        array[0] = 0
            array[1] =2
            array[2] =1
            array[3] = 0
//            array[4] =79
//            array[5] =78
//            array[6] =67
//            array[7] =36
//            array[8] =26
//            array[9] =19

            peakIndexInMountainArray(array)
    }
//    var results: Int = 0
//
//    fun peakIndexInMountainArray(arr: IntArray): Int {
//        // 不考虑边界
//        val start = 0 + 1
//        val end = arr.size - 2
//        twoMid(arr, start, end)
//        return results
//    }
//
//    // 二分法
//    private fun twoMid(arr: IntArray, start: Int, end: Int){
//        val mid = (start + end) / 2
//        if( mid == 0) return
//        if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
//            results = mid
//        }else{
//            if(start == end) return
//            twoMid(arr, start, mid)
//            twoMid(arr, mid + 1, end)
//        }
//    }

    // 双指针
    fun peakIndexInMountainArray(arr: IntArray): Int {
        // 不考虑边界
        var start = 0
        var end = arr.size - 1
        while (start != end){
            if(arr[start] < arr[start + 1]){
                start ++
            }else{
                return start
            }
            if(arr[end] < arr[end - 1]){
                end --
            }else{
                return end
            }
        }
        return start
    }
}

