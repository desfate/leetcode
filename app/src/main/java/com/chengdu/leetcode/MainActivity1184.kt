package com.chengdu.leetcode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.math.min


/**
1184. 公交站间的距离
环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。

环线上的公交车都可以按顺时针和逆时针的方向行驶。

返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 */
class MainActivity1184 {

    fun numPrimeArrangements(n: Int): Int {
        return 0
    }

    fun distanceBetweenBusStops(distance: IntArray, start: Int, destination: Int): Int {
        var right = start
        var left = destination
        if(right > left){
            right = left.apply { left = right }
        }

        var rightSum = 0
        var leftSum = 0
        for (index in 0..distance.size){
            if(index in right until left){
                rightSum += distance[index]
            }else{
                leftSum += distance[index]
            }
        }
        return min(rightSum, leftSum)
    }


}

