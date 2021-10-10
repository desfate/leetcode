package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.pow

class MainActivity441 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        arrangeCoins(1804289383)
    }

//    fun arrangeCoins(n: Int): Int {
//        // 公式计算 n > 0 去除负数解答
//        return ((kotlin.math.sqrt((8 * n.toLong()).toDouble() + 1) - 1) / 2).toInt()
//    }

    fun arrangeCoins(n: Int): Int {
        var min = kotlin.math.sqrt(n.toDouble()).toInt()  // 最小值应该为更号n
        var max = n // 最大则为n本身
        while (min < max){ // 二分法一次筛选掉一半数据
            val mid = (( max - min + 1 ) / 2) + min
            if(mid.toLong() * (mid + 1) / 2 <= n){
                min = mid
            }else{
                max = mid - 1
            }
        }
        return min
    }

}

