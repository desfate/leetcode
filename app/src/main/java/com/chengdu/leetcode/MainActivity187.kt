package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity187 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findRepeatedDnaSequences("AAAAAAAAAAA")
    }

//    fun findRepeatedDnaSequences(s: String): List<String> {
//        if(s.length < 10) return arrayListOf()
//        val hashMap = hashMapOf<String, Int>()
//        val result = arrayListOf<String>()
//        // 简单hashmap
//        s.forEachIndexed { index, c ->
//            if(index >= 9){
//                val key: String = s.subSequence(index - 9, index + 1).toString()
//                val value = hashMap.getOrDefault(key, 0) + 1
//                hashMap[key] = value
//                if( value == 2 ){
//                    result.add(key)
//                }
//            }
//        }
//        return result
//    }

    fun findRepeatedDnaSequences(s: String): List<String> {
        if (s.length < 10) return arrayListOf()
        // hashMap + 滑动窗口 + 数据转换
        val changMap = hashMapOf(
            'A' to 0,
            'C' to 1,
            'G' to 2,
            'T' to 3
        )

        val hashMap = hashMapOf<Int, Int>()
        val result = arrayListOf<String>()
        // 简单hashmap
        var key = 0
        s.forEachIndexed forEach@{ index, c ->
            if(index < 9){
                key = (key shl 2) or changMap[c]!!
                return@forEach
            }else{
                key = (key shl 2) or changMap[c]!! and ((1 shl 20) - 1)
            }
            hashMap[key] = hashMap.getOrDefault(key, 0) + 1
            if(hashMap[key] == 2){
                result.add(s.substring(index - 9,index + 1))
            }
        }
        return result
    }
}

