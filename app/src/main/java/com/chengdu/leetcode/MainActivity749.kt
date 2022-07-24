package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.absoluteValue
import kotlin.math.max

class MainActivity749 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    // 二维数组
    // 1.模拟扩散流程 （）
    fun containVirus(isInfected: Array<IntArray>): Int {
        isInfected.forEachIndexed { indexI, i ->
                isInfected[indexI].forEachIndexed { indexJ, j ->
                    if(isInfected[indexI][indexJ] == 1){  // 我是病毒 尝试向四周扩散
                        // 判断上下左右扩散的可行性
                        if(indexI - 1 >= 0 && isInfected[indexI - 1][indexJ] == 0){
                            isInfected[indexI - 1][indexJ] = -1  // 向上扩散
                        }
                        if(indexI + 1 <= isInfected.size - 1 && isInfected[indexI + 1][indexJ] == 0){
                            isInfected[indexI + 1][indexJ] = -1  // 向下扩散
                        }
                        if(indexJ + 1 <= isInfected[indexI].size - 1 && isInfected[indexI][indexJ + 1] == 0){
                            isInfected[indexI][indexJ + 1] = -1  // 向右扩散
                        }
                        if(indexJ - 1 >= isInfected[indexI].size - 1 && isInfected[indexI][indexJ - 1] == 0){
                            isInfected[indexI][indexJ - 1] = -1  // 向左扩散
                        }
                    }
                }
        }
        print(isInfected)
        return 0
    }


}

