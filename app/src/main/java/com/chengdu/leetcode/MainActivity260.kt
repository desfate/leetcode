package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.absoluteValue

class MainActivity260 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var hashMap = hashMapOf<Int, Boolean>()
    fun singleNumber(nums: IntArray): IntArray {
        nums.forEach {
            if(hashMap.containsKey(it)){
                hashMap.remove(it)
            }else{
                hashMap[it] = true
            }
        }
        val results = IntArray(2)
        var index = 0
        hashMap.forEach {
            results[index] = it.key
            index ++
        }

        return results
    }

}

