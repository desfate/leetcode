package com.chengdu.leetcode.classify.backtracking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chengdu.leetcode.R

class MainActivity47 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    val hashSet = hashSetOf<String>()

    fun permuteUnique(nums: IntArray): List<List<Int>> {
        permute(ArrayList<Int>(nums.asList()), "");
        return hashSet.map {
            it.split("_").map {
                it.toInt()
            }
        }
    }

    fun permute(nums: ArrayList<Int>, head: String) {
        if (nums.isEmpty()) {
            hashSet.add(head)
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

