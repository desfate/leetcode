package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.absoluteValue
import kotlin.math.max

class MainActivity745 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    class WordFilter(words: Array<String>) {
        var wordMap = hashMapOf<String, Int>()

        init {
            words.forEachIndexed { index, s ->
                wordMap[s] = index
            }
        }



        fun f(pref: String, suff: String): Int {
            var result = -1
            wordMap.forEach { (s, i) ->
                if (minIndex(pref, suff, s)) {
                    result = max(i, result)
                }
            }
            return result
        }

        fun minIndex(pref: String, suff: String, value: String): Boolean {
            if (value.isNotEmpty()) {
                val start = value.indexOf(pref, 0, false)
                if (start == -1) return false
                val end = value.indexOf(suff, value.length - 1 - suff.length, false)
                if (end == -1) return false
                if (start < end) {
                    return true
                } else if (start == end && pref == value) {
                    return true
                }
            }
            return false
        }

    }



}

