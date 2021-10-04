package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.absoluteValue
import kotlin.math.max

class MainActivity517 : AppCompatActivity() {

    var allSum = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intArray = IntArray(3)
        intArray[0] = 0
        intArray[1] = 3
        intArray[2] = 0
        System.out.println(findMinMoves(intArray))
    }

    fun findMinMoves(machines: IntArray): Int {
        machines.forEach {
            allSum += it
        }
        return if(allSum % machines.size != 0){
            -1
        }else{
            val avg = allSum / machines.size

            var minValue: Int = 0 // 集合A的最小移动次数
            var allValue = 0 //
            machines.forEach {
                val oneValue = it - avg  // 当前洗衣机需要的衣服个数  oneValue > 0 则衣服多了 oneValue < 0 则衣服少了
                allValue += oneValue  // 当前集合所需要的衣服个数 allValue > 0 则衣服多了 allValue < 0 则衣服少了
                minValue = max(minValue ,max(allValue.absoluteValue, oneValue))  // 最小移动次数 则为衣服的差值的绝对值中的最大值
            // !!! 这里注意 为什么oneValue不使用绝对值，是因为如果是获得衣服，则oneValue为负数，同时左右两边都可以给当前节点衣服，则不能作为最大值
            }
            minValue
        }
    }
}