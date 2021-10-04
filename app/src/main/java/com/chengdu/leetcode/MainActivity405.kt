package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.absoluteValue
import kotlin.math.max
import kotlin.math.min

class MainActivity405 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        print(toHex(26))
    }

    fun toHex(num: Int): String {
        val map: List<String> = arrayListOf(
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"
        )
        if(num == 0) return "0"
        var i = 7

        var ans = ""
        while (i >= 0){
            val value = (num shr (4 * i)) and 0xf  //  右移后按位与 提取高四位
            if(value > 0 || ans.isNotEmpty()) {
                ans += map[value]
            }
            i --
        }

        return ans
    }
}