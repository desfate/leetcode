package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.StringBuilder
import kotlin.math.absoluteValue
import kotlin.math.max
import kotlin.math.min

class MainActivity166 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fractionToDecimal(-2147483648
                ,-2147483648)
    }

    fun fractionToDecimal(numerator: Int, denominator: Int): String {
        val map: MutableMap<Long, Int> = HashMap()
        val sb = StringBuilder()
        // 输入用例里面数字较大
        val numerators = numerator.toLong().absoluteValue
        val denominators = denominator.toLong().absoluteValue
        if(numerator.toLong() % denominator.toLong() == 0L) return (numerator.toLong() / denominator.toLong()).toString()
        // 同时判断正负因为是和0比较 所以先转成long
        // 这里会有一个情况 就是没有-0
        if((numerator.toLong() > 0 && denominator.toLong() < 0) || (numerator.toLong() < 0 && denominator.toLong() > 0)){
            sb.append("-")
        }
        // 这里先求出整数部分
        sb.append((numerators / denominators).toString())
        sb.append(".")
        var remainder = numerators % denominators  // 余数
        var index = 0
        val sb2 = StringBuilder()
        while (remainder != 0L && !map.containsKey(remainder.toLong())){  // 如果除不尽 且 找不到循环节
            map[remainder.toLong()] = index
            index ++
            remainder *= 10
            sb2.append(remainder / denominators)
            remainder %= denominators
        }

        if (remainder != 0L){  // 这种情况是除不尽 但是有循环节
            sb2.insert(map[remainder.toLong()]!!, "(")
            sb2.append(")")
        }

        return sb.append(sb2).toString()
    }


}