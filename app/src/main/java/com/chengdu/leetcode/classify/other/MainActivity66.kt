package com.chengdu.leetcode.classify.other

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chengdu.leetcode.R

class MainActivity66 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intArray = IntArray(3)
        intArray[0] = 8
        intArray[1] = 9
        intArray[2] = 9
        plusOne(intArray)
    }

//    fun plusOne(digits: IntArray): IntArray {
//        // 转换成大数处理
//        return BigInteger(digits.joinToString("")).add(BigInteger("1")).toString().map { it.toString().toInt() }.toIntArray()
//    }

    fun plusOne(digits: IntArray): IntArray {
        var add = false  // 是否进位
        // 逐个数字处理
        val resultArray = arrayListOf<Int>()
        for(index in (digits.size - 1) downTo 0 ){
            if(index == digits.size - 1){
                if(digits[index] + 1 == 10){
                    add = true
                    resultArray.add(0)
                }else{
                    add = false
                    resultArray.add(digits[index] + 1)
                }
            }else{
                if(add){
                    if(digits[index] + 1 == 10){
                        add = true
                        resultArray.add(0)
                    }else{
                        add = false
                        resultArray.add(digits[index] + 1)
                    }
                }else{
                    add = false
                    resultArray.add(digits[index])
                }
            }
        }
        if(add) resultArray.add(1)
        return resultArray.reversed().toIntArray()
    }



}

