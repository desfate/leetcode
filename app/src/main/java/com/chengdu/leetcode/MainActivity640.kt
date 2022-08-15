package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity640 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    fun solveEquation(equation: String): String {
        // 符号只有 + - =   = 只有一个
        // 等号右边的  符号需要倒置
        // 合并同类项之后 只会剩下 ax + b = 0  则 x = - b / a

        var a = 0
        var b = 0

        var last: Char? = null
        var lastIndex = 0
        equation.forEachIndexed { index, c ->  // 循环一边就可以统计了
            // 两个符号之间的肯定是数字
            if(isCal(c)){
                if(last == null){
                    var info = equation.substring(0, index)
                    if(info.contains('x')){
                        info = info.replace("x","")
                        a += if(info.isEmpty()){1}else{info.toInt()}
                    }else{
                        b += info.toInt()
                    }


                    last = c
                    lastIndex = index
                    // 记录第一个计算符号

                }
            }


        }
        return ""
    }

    fun isCal(s: Char): Boolean{
        return (s == '+') || (s == '-')
    }
}

