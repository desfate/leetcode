package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.absoluteValue

class MainActivity869 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        reorderedPowerOf2(10)
    }

    fun reorderedPowerOf2(n: Int): Boolean {
        // 通过递归的方式可以实现随机打乱
        randomNumber(n.toString(), "")
        return results
    }

    var results: Boolean = false

    /**
     * 随机打乱数据 并加入一个list
     */
    fun randomNumber(s: String, value: String){
        if((value + s).length >= 2 && (value + s)[0] == '0') return
        if(s.length == 1){
            if(check((value + s).toInt())){
                results = true
            }
        }
        s.forEachIndexed { index, c ->
            randomNumber(s.substring(0, index) + s.substring(index + 1, s.length),   value + c.toString())
        }
    }

    /**
     * 判断数字是否是2的阶乘
     */
    fun check(value: Int): Boolean{
        return value.and(value - 1) == 0
    }

}

