package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.text.StringBuilder

class MainActivity230 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var result = arrayListOf<String>()
    fun addOperators(num: String, target: Int): List<String> {
        // 先生成n-1个符号用于计算
        // 生成的同时也进行计算
        var sum = 0
        var resultValue = ""
        for(index in 0..num.length - 2){
            for(sign in 0..3){
                val nowValue = num[index].toString()
                val nextValue = num[index + 1].toString().toInt()
                when(sign){
                    0 -> {
                        resultValue += nowValue + nextValue
                        sum = sum * 10 + nextValue
                    }
                    1 -> {
                        resultValue += "+$nextValue"
                        sum += nextValue
                    }
                    2 -> {
                        resultValue += "-$nextValue"
                        sum -= nextValue
                    }
                    3 -> {
                        resultValue += "*$nextValue"
                        sum *= nextValue
                    }
                }
            }
        }

        num.length - 1






        return result
    }

}

