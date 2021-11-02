package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity240 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val array1 = IntArray(5)
        array1[0] = 1
        array1[1] = 2
        array1[2] = 3
        array1[3] = 4
        array1[4] = 5
        val array2 = IntArray(5)
        array2[0] = 6
        array2[1] = 7
        array2[2] = 8
        array2[3] = 9
        array2[4] = 10
        val array3 = IntArray(5)
        array3[0] = 11
        array3[1] = 12
        array3[2] = 13
        array3[3] = 14
        array3[4] = 15
        val array4 = IntArray(5)
        array4[0] = 16
        array4[1] = 17
        array4[2] = 18
        array4[3] = 19
        array4[4] = 20
        val array5 = IntArray(5)
        array5[0] = 21
        array5[1] = 22
        array5[2] = 23
        array5[3] = 24
        array5[4] = 25

        val arrayList = arrayOf(
            array1,array2,array3,array4,array5
        )

//        searchMatrix(arrayList, 15)
    }


//    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
//        // 遍历整个数组
//        matrix.forEach {
//            it.forEach {
//                if(it == target) return true
//            }
//        }
//        return false
//    }

//    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
//        // 简单二分查找  只对第二层循环做二分查找
//        matrix.forEach {
//            if(twoSearch(it, target)){
//                return true
//            }
//        }
//        return false
//    }
//
//    fun twoSearch(array: IntArray, target: Int): Boolean{
//        var min = 0
//        var max = array.size - 1
//        while (min <= max){
//            val mid = (max - min / 2) + min
//            if(array[mid] == target){
//                return true
//            } else if(array[mid] > target){
//                max = mid
//            } else {
//                min = mid
//            }
//        }
//        return false
//    }

//    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
//        // 通过特点查找
//        // 通过矩阵最后一列 可以找到每列最大的值 就可以确定数字可能出现的列数
//        val minValue = matrix[0].last()
//        matrix.forEachIndexed { index, ints ->
//
//
//    }



}

