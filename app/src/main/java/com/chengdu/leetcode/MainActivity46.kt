package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.text.StringBuilder

class MainActivity46 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    val result = arrayListOf<List<Int>>()

    fun permute(nums: IntArray): List<List<Int>> {
        permute(ArrayList<Int>(nums.asList()), "");
        return result
    }


    fun permute(nums: ArrayList<Int>, head: String) {
        if (nums.isEmpty()) {
            result.add(head.split("_").map { it.toInt() })
        }
        // 等于对子问题求解
        nums.forEach {
            val list = arrayListOf<Int>()
            list.addAll(nums)
            list.remove(it)
            permute(
                list, if (head.isEmpty()) {
                    it.toString()
                } else {
                    head + "_" + it
                }
            )
        }
    }

}

