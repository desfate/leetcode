package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.StringBuilder
import kotlin.math.pow

class MainActivity273 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numberToWords(790000000)
        System.out.println("")
    }

    // 个位数的映射表
    val oneMap = hashMapOf(
        '0' to "",
        '1' to " One",
        '2' to " Two",
        '3' to " Three",
        '4' to " Four",
        '5' to " Five",
        '6' to " Six",
        '7' to " Seven",
        '8' to " Eight",
        '9' to " Nine"
    )

    // 十位数的映射表
    val twoMap = hashMapOf(
        '0' to "",
        '1' to " Ten",
        '2' to " Twenty",
        '3' to " Thirty",
        '4' to " Forty",
        '5' to " Fifty",
        '6' to " Sixty",
        '7' to " Seventy",
        '8' to " Eighty",
        '9' to " Ninety"
    )

    // 10 - 20 情况下的映射表
    val tenMap = hashMapOf(
        '0' to " Ten",
        '1' to " Eleven",
        '2' to " Twelve",
        '3' to " Thirteen",
        '4' to " Fourteen",
        '5' to " Fifteen",
        '6' to " Sixteen",
        '7' to " Seventeen",
        '8' to " Eighteen",
        '9' to " Nineteen"
    )

    fun numberToWords(num: Int): String {
        // 这里进行一位一位的转换
        // 先倒序 则index == 0 的情况是个位  以此类推
        if (num == 0) return "Zero"
        var result = ""
        var preResult = result  // 这里缓存一下之前的变化 因为11，12，13。。。19 需要把个位合并进去
        var preNum = 'a'
        var preUnit = ""
        num.toString().reversed().forEachIndexed { index, c ->
            when (index + 1) {
                1 -> {
                    preNum = c
                    if(oneMap[c]!! == " Zero"){  // 排除0的情况
                        result = ""
                    }else {
                        result = oneMap[c]!! + unitString(index + 1)
                    }
                }
                4, 7 -> {  // 1， 4， 7 需要做缓存
                    preResult = result  // 缓存
                    if(oneMap[c]!!.isNotEmpty()) {
                        result = oneMap[c]!! + unitString(index + 1) + result
                    }
                    preNum = c  // 这里保存的是个位数
                }
                2, 5, 8 -> {
                    if (c == '1' && preNum != 'a') {  // 十位为1 则
                        preResult = if (preResult.isNotEmpty()) {
                            tenMap[preNum] + unitString(index + 1) + preResult
                        } else {
                            tenMap[preNum] + unitString(index + 1)
                        }
                        result = preResult
                    } else if(index + 1 == 2){
                        // 十位的情况下 因为默认是没有单位的
                        result = twoMap[c] + oneMap[preNum] + unitString(index + 1)
                    } else {  // 其他情况后置单位
                        if(unitString(index + 1).isNotEmpty()) {
                            if(!(c == '0' && preNum == '0')){
                                preUnit = ""
                                result = twoMap[c] + oneMap[preNum] + unitString(index + 1) + preResult
                            }else {
                                preUnit = unitString(index + 1)
                            }
                        }else{
                            result = twoMap[c] + preResult
                        }
                    }
                }
                6,9 -> {
                    if(oneMap[c]!!.isNotEmpty()) {
                        result = if(c != '0' && preNum == '0'){
                            oneMap[c] + unitString(index + 1)  + preUnit + result
                        }else {
                            oneMap[c] + unitString(index + 1) + result
                        }
                    }
                }
                else -> {
                    if(!(c == '0')){
                        result = oneMap[c] + unitString(index + 1) + result
                    }
                }
            }
        }
        return result.substring(1,result.length)
    }

    fun unitString(index: Int): String {
        return when (index) {
            1, 2 -> ""
            3, 6, 9 -> " Hundred"
            4, 5 -> " Thousand"
            7, 8 -> " Million"
            10 -> " Billion"
            else -> ""
        }
    }

}

