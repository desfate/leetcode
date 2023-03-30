package com.chengdu.leetcode.classify.other

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.max
import kotlin.math.min
import kotlin.text.StringBuilder

/**
 * 给你 n 个二维平面上的点 points ，其中 points[i] = [xi, yi] ，请你返回两点之间内部不包含任何点的 最宽垂直区域 的宽度。

垂直区域 的定义是固定宽度，而 y 轴上无限延伸的一块区域（也就是高度为无穷大）。 最宽垂直区域 为宽度最大的一个垂直区域。

请注意，垂直区域 边上 的点 不在 区域内。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/widest-vertical-area-between-two-points-containing-no-points
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MainActivity1637 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val point1 = intArrayOf(3, 1)
        val point2 = intArrayOf(9, 0)
        val point3 = intArrayOf(1, 0)
        val point4 = intArrayOf(1, 4)
        val point5 = intArrayOf(5, 3)
        val point6 = intArrayOf(8, 8)
        val points = arrayOf(point1, point2, point3, point4, point5, point6)
        println(maxWidthOfVerticalArea(points))
    }

    // 快排后一次循环
    fun maxWidthOfVerticalArea(points: Array<IntArray>): Int {
        // 二维变一维
        val pointX = IntArray(points.size)
        points.forEachIndexed { index, ints -> pointX[index] = ints[0] }

        pointX.reversed() // 数组排序

        //排序后判断最大间隔 一次循环即可
        var sum = 0
        pointX.forEachIndexed { index, i ->
            if (index < pointX.size - 2){
                sum = max(sum , pointX[index + 1] - pointX[index])
            }
        }
        return sum
    }

}

