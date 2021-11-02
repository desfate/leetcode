package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity496 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        [4,1,2]
//        [1,3,4,2]

        val array1 = IntArray(3)
        array1[0] = 4
        array1[1] = 1
        array1[2] = 2
        val array2 = IntArray(4)
        array2[0] = 1
        array2[1] = 3
        array2[2] = 4
        array2[3] = 2

        nextGreaterElement(array1, array2)

    }

//    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
//        val resultArray = IntArray(nums1.size)
//        // 暴力遍历
//        nums1.forEachIndexed { indexJ, j ->
//            resultArray[indexJ] = -1  // 设置默认值
//            var min = j
//            var saveIndex = -1
//
//            for(indexI in nums2.indices){
//                if (j == nums2[indexI]) { // 找到了对应元素 然后向后
//                    saveIndex = indexI
//                }
//
//                if (saveIndex != -1) {  // 找大于j的值
//                    if (nums2[indexI] > j) {
//                        min = nums2[indexI]
//                        break
//                    }
//                }
//            }
//
//            if (min != j) {
//                resultArray[indexJ] = min
//            }
//        }
//        return resultArray
//    }


    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val targetHash = hashMapOf<Int, Int>()
        // hashmap
        nums1.forEach {
            targetHash[it] = -1
        }
        var start = 0
        var end = 0
        while (start != nums2.size){
            if(targetHash.containsKey(nums2[start])){ // 如果在子串中
                while (end != nums2.size){
                    if(nums2[end] <= nums2[start]){
                        end ++
                    }else{
                        break
                    }
                }
                if(nums2[end] > nums2[start]) targetHash[nums2[start]] = nums2[end]
            }else{
                start ++
                end = start
            }
        }
        val array = IntArray(nums1.size)
        var index = 0
        targetHash.forEach {
            array[index] = it.value
            index ++
        }
        return array
    }

}

