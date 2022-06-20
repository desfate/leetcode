package com.chengdu.leetcode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*


/**
 * 学校打算为全体学生拍一张年度纪念照。根据要求，学生需要按照 非递减 的高度顺序排成一行。

排序后的高度情况用整数数组 expected 表示，其中 expected[i] 是预计排在这一行中第 i 位的学生的高度（下标从 0 开始）。

给你一个整数数组 heights ，表示 当前学生站位 的高度情况。heights[i] 是这一行中第 i 位学生的高度（下标从 0 开始）。

返回满足 heights[i] != expected[i] 的 下标数量 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/height-checker
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MainActivity1051 {

    /**
     * 快速排序
     */
    fun quickSork(tagList: IntArray, start: Int, end: Int){
        if(start >= end){
            return
        }

        // 如何寻找当前点的位置
        // 双边指针
        var pivot = PointSwap(tagList, start, end)
        // 单边指针

        quickSork(tagList, start, pivot - 1)
        quickSork(tagList, pivot + 1, end)
    }


    fun PointSwap(tagList: IntArray, start: Int, end: Int): Int{
        val pivot = tagList[start]
        var leftPoint: Int = start
        var rightPoint: Int = end
        while (
            leftPoint < rightPoint
        ){
            while ((leftPoint < rightPoint) && tagList[end] > pivot){
                rightPoint --
            }

            while ((leftPoint < rightPoint) && tagList[start] < pivot){
                leftPoint ++
            }

            if(leftPoint < rightPoint){
                val temp = tagList[rightPoint]
                tagList[rightPoint] = tagList[leftPoint]
                tagList[leftPoint] = temp
            }
        }
        // 最终将分界值与当前指针数据交换
        tagList[start] = tagList[rightPoint];
        tagList[rightPoint] = pivot;
        // 返回分界值所在下标
        return rightPoint;
    }
}

