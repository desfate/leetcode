package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.text.StringBuilder

class MainActivity211 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    class WordDictionary() {

        private val hashMap = hashMapOf<String, Boolean>()

        fun addWord(word: String) {
            hashMap[word] = true
        }

        fun search(word: String): Boolean {
            when {
                hashMap.containsKey(word) -> {
                    return hashMap[word]!!
                }
                word.contains(".") -> {
                    hashMap.forEach {
                        // 循环整个hashmap 进行通配符匹配
                        if(mate(word, it.key)){
                            return true
                        }
                    }
                    return false
                }
                else -> {
                    return false
                }
            }
        }

        private fun mate(word: String, target: String): Boolean{
            if(word.length != target.length) return false
            word.forEachIndexed { index, c ->
                if(c != '.' && c != target[index]){
                    return false
                }
            }
            return true
        }

    }


}

