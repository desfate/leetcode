package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.math.absoluteValue

class MainActivity575 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lists = arrayOf("zxcvbnm")
        findWords(lists)
    }

    val list = "qwertyuiopasdfghjklzxcvbnm"
    val hashmap = hashMapOf<String, Int>()
    var results = arrayListOf<String>()
    fun findWords(words: Array<String>): Array<String> {
        list.forEachIndexed { index, c ->
            hashmap[c.toString()] = index
        }

        words.forEach {
            val low = it.toLowerCase()
            var first = false
            var second = false
            var third = false
            low.forEach {
                if(hashmap[it.toString()]!! in 0..9){
                    first = true
                    if(second || third){
                        return@forEach
                    }
                }else if(hashmap[it.toString()]!! in 10..18){
                    second = true
                    if(first || third){
                        return@forEach
                    }
                }else {
                    third = true
                    if(first || second){
                        return@forEach
                    }
                }
            }
            if((first && !second && !third) || (!first && second && !third) || (!first && !second && third) ){
                results.add(it)
            }
        }
        return results.toTypedArray() as Array<String>
    }

}

