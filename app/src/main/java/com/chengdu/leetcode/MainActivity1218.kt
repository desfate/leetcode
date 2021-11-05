package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.math.absoluteValue
import kotlin.math.max

class MainActivity1218 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val array1 = IntArray(18)
        array1[0] = 7
        array1[1] = -2
        array1[2] = 8
        array1[3] = 10
        array1[4] = 6
        array1[5] = 18
        array1[6] = 9
        array1[7] = -8
        array1[8] = -5
        array1[9] = 18
        array1[10] = 13
        array1[11] = -6
        array1[12] = -17
        array1[13] = -1
        array1[14] = -16
        array1[15] = -9
        array1[16] = 9
        array1[17] = 9

        //[7,-2,8,10,6,18,9,-8,-5,18,13,-6,-17,-1,-6,-9,9,9]
        longestSubsequence(array1, 1)
    }

    val hashMap = hashMapOf<Int, Int>()
    fun longestSubsequence(arr: IntArray, difference: Int): Int {
       // 一遍循环 通过hashmap
        arr.forEach {
            if(hashMap.containsKey(it)){
                if(it + difference == it){
                    hashMap[it] = hashMap[it]!! + 1
                }else {
                    hashMap[it + difference] = hashMap[it]!! + 1
                    hashMap.remove(it)
                }
            }else{
                if(!hashMap.containsKey(it + difference)){
                    hashMap[it + difference] = 1
                }
            }
        }
        var max = 0
        hashMap.forEach{
            max = max(max, it.value)
        }
        return max
    }

}

