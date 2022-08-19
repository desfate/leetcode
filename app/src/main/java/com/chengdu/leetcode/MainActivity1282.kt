package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.absoluteValue
import kotlin.math.max

class MainActivity1282 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    val hashMap = hashMapOf<Int, List<Int>>()

//    fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
//
//        var result = listOf<List<Int>>()
//        var signIndex = groupSizes.size
//
//        groupSizes.forEachIndexed { index, i ->
//            ((hashMap.getOrDefault(i, arrayListOf<Int>())) as ArrayList<Int>).add(index)
//        }
//        // 按 key 把 value 切割成 n份  空余部分用 signIndex 补充 补充后 ++
//        hashMap.forEach { its ->
//            its.value.forEach {
//                // 将its.value 切割成 n 份 its.key 长度的数组
//
//            }
//        }
//    }

}

