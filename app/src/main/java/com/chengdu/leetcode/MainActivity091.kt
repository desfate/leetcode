package com.chengdu.leetcode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.min
import kotlin.text.StringBuilder

class MainActivity091 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    // 这种题目肯定是动态规划
    // 先用暴力破解
//    fun minCost(costs: Array<IntArray>): Int {
//        if(costs.isNotEmpty()){
//            costs[0].forEachIndexed { index, i ->
//                calCost(costs, 0, index, i)
//            }
//        }else{
//            return 0
//        }
//        return min
//    }
//
//    var min = Int.MAX_VALUE;
//    // 利用递归返回计算后的结果
//        private fun calCost(costs: Array<IntArray>, nowIndex: Int, preInt: Int, cost: Int){
//        if(nowIndex + 1 == costs.size){
//            min = min(cost, min)
//        }else{
//            costs[nowIndex].forEachIndexed { index, i ->
//                if(index != preInt){
//                    calCost(costs, nowIndex + 1, index, cost + i)
//                }
//            }
//        }
//    }

    fun minCost(costs: Array<IntArray>): Int {
        var n = costs.size - 1
        var arrays = IntArray(3)
        for (i in 0..2){
            arrays[i] = costs[0][i]
        }

        for (i in 1..n){
            var newArray = IntArray(3)
            for (j in 0..2){
                newArray[j] = min(arrays[(j + 1) % 3], arrays[(j  + 2)  % 3]) + costs[i][j]
            }
            arrays = newArray
        }
        var min = Int.MAX_VALUE
        arrays.forEach {
            min = min(min, it)
        }
        return min

    }


}

