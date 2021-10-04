package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.absoluteValue
import kotlin.math.max
import kotlin.math.min

class MainActivity1436 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = arrayListOf<List<String>>(
            arrayListOf("New York","Lima"),
            arrayListOf("Lima","Sao Paulo"),
            arrayListOf("London","New York"),


        )
        destCity(list)
    }

//    fun destCity(paths: List<List<String>>): String {
//        val hashMap :HashMap<String , Int> = HashMap()
//        // 通过hashmap 哪个地区能匹配的数据为0 则是终点
//        paths.forEach {
//            hashMap.put(it.last(), 0)
//        }
//
//        paths.forEach {
//            if(hashMap.getOrDefault(it.first(), -1) != -1){
//                hashMap.put(it.first(), 1)
//            }
//        }
//
//        hashMap.forEach {
//            if(it.value == 0){
//                return it.key
//            }
//        }
//
//        return ""
//    }

    fun destCity(paths: List<List<String>>): String {
        val list :ArrayList<String> = arrayListOf()
        // 通过hashmap 哪个地区能匹配的数据为0 则是终点
        paths.forEach {
            list.add(it.first())
        }

        return paths.find {
            !list.contains(it.last())
        }!!.last()
    }

}