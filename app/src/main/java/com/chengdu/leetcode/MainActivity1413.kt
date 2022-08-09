package com.chengdu.leetcode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity1413 {

    fun minStartValue(nums: IntArray): Int {
        // 循环数组判断最小插 n = n + n1
        var last: Int? = null
        var min = Int.MAX_VALUE
        nums.forEach {
            last = if(last == null){
                it
            }else{
                last!! + it
            }
            if( min > last!! ){
                min = last!!
            }
        }

        return if(min >= 1) 1
        else 1 - min
    }


}

